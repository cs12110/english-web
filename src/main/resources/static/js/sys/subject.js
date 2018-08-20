//code by lucien

var page = {
	index : 0,
	rows : 20
};

var words = [];
var keywords = [];
var curSentence = null;
var wordIndex = 0;
var readIndex = 1;
var score = {
	cusId : null,
	subId : null,
	readTime1 : null,
	readTime2 : null,
	readTime3 : null,
	readTime4 : null,
	readTime5 : null,
	correct : null,
	stopwatch : "",
};
var sentenceIndex = 0;

var subjects = [];
var $nextSentenceBtn = $('[data-next-sentence]');
var $nextWorkBtn = $('[data-next-ward]');
var $relaxBtn = $('[data-relax-btn]');
var $wordBox = $('.each-word');

function getSubjects() {
	page.index = page.index + 1;
	$.ajax({
		url : "/subject/list",
		data : {
			"page" : page.index,
			"rows" : page.rows
		},
		dataType : "json",
		success : function(data) {
			subjects = data;
			// 开始从第一个显示
			nextSentence();
		}
	})
}

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
		subId : null,
		readTime1 : null,
		readTime2 : null,
		readTime3 : null,
		readTime4 : null,
		readTime5 : null,
		correct : null,
		stopwatch : ""
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
		$wordBox.append('<div data-work-index="' + index
				+ '" class="show-word"></div>')
	}
}

var readBeginTime = null;

function readTime(start) {
	var m = new Date;
	return m - start;
}

function nextSentence() {
	var subject = subjects[sentenceIndex];
	if (!subject) { // 休息一下啦。
		$('[data-relax]').css('display', '');
		$('#operatorBtn').find('input').attr('disabled', 'disabled');
		sentenceIndex = 0;
		clearSentenceData();
		return false;
	}
	transSentenceData(subject);
	sentenceIndex += 1;
}

var watcher = null;
$(document).ready(function() {

	getSubjects();

	var stopwatchArr = new Array();
	$nextWorkBtn.click(function() {
		var len = words.length;
		var prev = wordIndex - 1;
		if (wordIndex > 0) {
			$('[data-work-index="' + prev + '"]').empty();
		}

		if (wordIndex < len) {
			if (wordIndex == 0) {
				watcher = new Date();
			} else {
				var now = new Date();
				var key = "" + words[wordIndex - 1];
				var time ={
						"key":key,
						"value":now-watcher
				}
				stopwatchArr.push(time);
				watcher = now;
			}
			var word = words[wordIndex];
			$('[data-work-index="' + wordIndex + '"]').append(word);
			wordIndex++;
		} else {
			var now = new Date();
			var key = "" + words[wordIndex - 1];
			var time ={
					"key":key,
					"value":now-watcher
			}
			stopwatchArr.push(time);
			$('.question-area').css('display', '');
			$('#question').text(curSentence.question);
		}
		// if (wordIndex < len) {
		// console.log(word);
		// stopwatchArr['' + word + ''] = readTime(readBeginTime);
		// if (wordIndex == 0) {
		// readBeginTime = new Date();
		// }
		// var word = words[wordIndex];
		// $('[data-work-index="' + wordIndex + '"]').append(word);
		//
		// if (readBeginTime != null) {
		// var reTime = readTime(readBeginTime);
		// var reProperty = 'readTime' + readIndex;
		// score['' + reProperty + ''] = reTime;
		// readIndex += 1;
		// readBeginTime = null;
		// }
		// if ($.inArray(word, keywords) !== -1) {
		// readBeginTime = new Date();
		// }
		// wordIndex += 1;
		// } else {
		// $('.question-area').css('display', '');
		// $('#question').text(curSentence.question);
		// }
	});

	$('#submit').click(function() {
		var chk = $('input[name="answer"]:checked').val();
		if (chk === curSentence.answer) {
			score.correct = 1;
		} else {
			score.correct = 0;
		}

		var valueAsStr ="";
		var len = stopwatchArr.length;
		for(var i =0; i<len;i++ ){
			var temp = stopwatchArr[i];
			valueAsStr += temp.key+"#"+temp.value;
			if(i<len-1){
				valueAsStr +=",";
			}
		}
		
		score.stopwatch = valueAsStr;
		console.log(score);

		$.post('/score/save', score, function(data) {
			if (data.status !== 1) {
				alert(data.message);
			}
		}, "json");
		stopwatchArr = new Object();
		nextSentence();
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

});