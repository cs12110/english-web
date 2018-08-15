//code by lucien


var page = {
    index: 0,
    rows: 20
};

var subjects = [];
var $nextSentenceBtn = $('[data-next-sentence]');
var $nextWorkBtn = $('[data-next-work]');
var $relaxBtn = $('[data-relax-btn]');
var $wordBox=$('.each-word');

function getSubjects() {
    page.index = page.index + 1;
    $.ajax({
        url: "/subject/list",
        data: {
            "page": page.index,
            "rows": page.rows
        },
        dataType: "json",
        success: function (data) {
            subjects = data;
            console.log(data);
            // 开始从第一个显示
            $nextSentenceBtn.click();
        }
    })
}

var words = [];
var keywords = [];
var question = '';
var answer = '';
var wordIndex=0;

function transStrToArr(str) {
    var words = str.split(" ");
    return words;
}

function clearSentenceData() {
    words = [];
    keywords = [];
    question = '';
    answer = '';
    wordIndex=0;
    $('.question-area').css('display','none');
    $wordBox.empty();
}

function transSentenceData(subject) {
    clearSentenceData();
    words = transStrToArr(subject.sentence);
    generatorWordPosition(words);
    keywords = transStrToArr(subject.keyword);
    question = subject.question;
    answer = subject.answer;
}

function generatorWordPosition(words) {
    var len=words.length;
    for(var index=0;index<len;index++){
        $wordBox.append('<div data-work-index="'+index+'" class="show-word"></div>')
    }
}

var readBeginTime=null;

function readTime(start) {
    var m=new Date;
    console.log(m-start);
}

$(document).ready(function () {

    getSubjects();

    $nextWorkBtn.click(function () {
        var len = words.length;
        if(wordIndex<len){
            var word=words[wordIndex];
            $('[data-work-index="'+wordIndex+'"]').append(word);

            if(readBeginTime!=null){
                readTime(readBeginTime);
                readBeginTime=null;
            }

            if($.inArray(word,keywords)!=-1){
                readBeginTime=new Date();
            }
            wordIndex+=1;
        }else {
            $('.question-area').css('display','');
            $('#question').text(question);
        }
    });

    $('#submit').click(function () {
        console.log( $('input[name="answer"]:checked').val());
        $nextSentenceBtn.click();
        return false;
    });

    $relaxBtn.click(function () {
        if ($(this).data('relax-btn')) {
            //点击休息 do something
        } else {
            $('[data-relax]').css('display', 'none');
            $('#operatorBtn input').removeAttr("disabled");
            getSubjects();
            $(this).data('index', 0);
        }
    });

    $nextSentenceBtn.click(function () {
        var index=$(this).data('index');
        var subject = subjects[index];
        if (!subject) {//休息一下啦。
            $('[data-relax]').css('display', '');
            $(this).data('index', 0)
            $('#operatorBtn input').attr('disabled', 'disabled');
            clearSentenceData();
            return false;
        }
        console.log(subject);
        transSentenceData(subject);
        $(this).data('index', index+1);
    });


});


