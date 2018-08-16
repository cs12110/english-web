//code by lucien

var page = {
    index: 0,
    rows: 20
};

var subjects = [];
var $nextSentenceBtn = $('[data-next-sentence]');
var $nextWorkBtn = $('[data-next-ward]');
var $relaxBtn = $('[data-relax-btn]');
var $wordBox = $('.each-word');

function getSubjects() {
    page.index = page.index + 1;
    $.ajax({
        url: "/subject/list",
        data: {
            "page": page.index,
            "rows": page.rows
        },
        dataType: "json",
        success: function(data) {
            subjects = data;
            // 开始从第一个显示
            $nextSentenceBtn.click();
        }
    })
}

var words = [];
var keywords = [];
var curSentence = null;
var wordIndex = 0;
var readIndex = 1;
var score = {
    cusId: null,
    subId: null,
    readTime1: null,
    readTime2: null,
    readTime3: null,
    readTime4: null,
    readTime5: null,
    correct: null,
};

function transStrToArr(str) {
    var words = str.split(" ");
    return words;
}

function clearSentenceData() {
    words = [];
    keywords = [];
    wordIndex = 0;
    curSentence = null;
    $('.question-area').css('display', 'none');
    $('input[name="answer"]:checked').prop("checked", false);
    readIndex = 1;
    $wordBox.empty();
    score = {
        subId: null,
        readTime1: null,
        readTime2: null,
        readTime3: null,
        readTime4: null,
        readTime5: null,
        correct: null,
    };
}

function transSentenceData(subject) {
    clearSentenceData();
    words = transStrToArr(subject.sentence);
    generatorWordPosition(words);
    keywords = transStrToArr(subject.keyword);
    curSentence = subject;
    score.subId = subject.id;
}

function generatorWordPosition(words) {
    var len = words.length;
    for (var index = 0; index < len; index++) {
        $wordBox.append('<div data-work-index="' + index +
            '" class="show-word"></div>')
    }
}

var readBeginTime = null;

function readTime(start) {
    var m = new Date;
    return m - start;
}

$(document).ready(function() {

    getSubjects();

    $nextWorkBtn.click(function() {
        var len = words.length;
        var prev = wordIndex - 1;
        if (wordIndex > 0)
            $('[data-work-index="' + prev + '"]').empty();

        if (wordIndex < len) {
            var word = words[wordIndex];
            $('[data-work-index="' + wordIndex + '"]').append(word);

            if (readBeginTime != null) {
                var reTime = readTime(readBeginTime);
                var reProperty = 'readTime' + readIndex;
                score['' + reProperty + ''] = reTime;
                readIndex += 1;
                readBeginTime = null;
            }

            if ($.inArray(word, keywords) !== -1) {
                readBeginTime = new Date();
            }
            wordIndex += 1;
        } else {
            $('.question-area').css('display', '');
            $('#question').text(curSentence.question);
        }
    });

    $('#submit').click(function() {
        var chk = $('input[name="answer"]:checked').val();
        if (chk === curSentence.answer) {
            score.correct = 1;
        } else {
            score.correct = 0;
        }
        if (score.subId !== null) {
            $.post('/score/save', score, function() {}, "json");
        }
        $nextSentenceBtn.click();
        return false;
    });

    $relaxBtn.click(function() {
        if ($(this).data('relax-btn')) {
            // 点击休息 do something
        } else {
            $('[data-relax]').css('display', 'none');
            $('#operatorBtn').find('input').removeAttr("disabled");
            getSubjects();
            $(this).data('index', 0);
        }
    });

    $nextSentenceBtn.click(function() {
        var index = $(this).data('index');
        var subject = subjects[index];
        if (!subject) { // 休息一下啦。
            $('[data-relax]').css('display', '');
            $(this).data('index', 0)
            $('#operatorBtn').find('input').attr('disabled', 'disabled');
            clearSentenceData();
            return false;
        }
        transSentenceData(subject);
        $(this).data('index', index + 1);
    });

});