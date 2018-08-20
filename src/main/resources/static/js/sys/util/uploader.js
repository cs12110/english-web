/**
 * 动态获取上传服务器url位置
 */
function getDynamicUploadUrl() {
    return $("input[name=takeFileUrl]").val();
}

$(function() {
    var state = 'pending';
    var uploader = WebUploader.create({

        // swf文件路径
        swf: '/static/js/plugin/webuploader/Uploader.swf',

        // 文件接收服务端。
        server: "/admin/upload",

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id: '#picker'
        },

        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
    });


    /**
     * 设置携带参数
     */
    uploader.on('uploadBeforeSend', function(block, data) {
        var file = block.file;
        data.paper = $("input[name=paper]:checked").val();
    });
    /**
     * 验证文件格式以及文件大小
     */
    uploader.on('error', function(type) {
        if (type == "Q_TYPE_DENIED") {
            alert("myModal", "messageP", "请上传xlsx格式文件");
        }
    });

    uploader.on('fileQueued', function(file) {
        $("#thelist").append(
            '<div id="' + file.id + '" class="item">' + '<h4 class="info">' +
            file.name + '</h4>' + '<p class="state">等待上传...</p>' +
            '</div>');
    });

    // 文件上传过程中创建进度条实时显示。
    uploader
        .on(
            'uploadProgress',
            function(file, percentage) {
                var $li = $('#' + file.id),
                    $percent = $li
                    .find('.progress .progress-bar');

                // 避免重复创建
                if (!$percent.length) {
                    $percent = $(
                            '<div class="progress progress-striped active">' +
                            '<div class="progress-bar" role="progressbar" style="width: 10%">' +
                            '</div>' + '</div>')
                        .appendTo($li).find('.progress-bar');
                }

                $li.find('p.state').text('上传中');

                $percent.css('width', percentage * 100 + '%');
            });

    uploader.on('uploadSuccess', function(file, response) {
        var data = response;
        var str = "";
        /*
         * 上传成功
         */
        if (data.status == 1) {
            $('#' + file.id).find('p.state').text('已上传');
            str = "成功: " + data.success + "条数据,失败: " + data.failure + "条数据.";
        } else {
        	$('#' + file.id).find('p.state').text(data.message);
            str = data.message;
        }
        alert(str);
    });

    uploader.on('uploadError', function(file) {
        $('#' + file.id).find('p.state').text('上传出错');
    });

    uploader.on('uploadComplete', function(file) {
        $('#' + file.id).find('.progress').fadeOut();
    });

    uploader.on('all', function(type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $("#ctlBtn").text('正在上传');
        } else {
            $("#ctlBtn").text('上传文件');
        }
    });

    $("#ctlBtn").on('click', function() {
        if (state === 'uploading') {
            uploader.stop();
        } else {
        	var paper = $("input[name=paper]:checked").val();
        	if(paper==undefined){
        		alert("请先选择上传文件类型");
        		return ;
        	}
            uploader.upload();
        }
    });
})