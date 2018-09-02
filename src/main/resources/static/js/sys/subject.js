//code by lucien

var page = {
	index: 0,
	rows: 20
};

var words = [];
var keywords = [];
var curSentence = null;
var wordIndex = 0;
var readIndex = 1;
var score = {
	cusId: null,
	subId: null,
	correct: null,
	stopwatch: "",
	paper: 0
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
		url: "/subject/list",
		data: {
			"page": page.index,
			"rows": page.rows
		},
		dataType: "json",
		success: function (response) {
			//这里要进行判断
			if(response.status==1){
				subjects = response.data;
				nextSentence();
			}
		}
	})
}

function transStrToArr(str) {
	if (str == undefined) {
		return [];
	}
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
		correct: null,
		stopwatch: ""
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
	 // 休息一下啦
	if (!subject) {
		
		$("#askToRest").modal({backdrop: 'static', keyboard: false});
		$('#operatorBtn').find('input').attr('disabled', 'disabled');
		
		sentenceIndex = 0;
		clearSentenceData();

		
		return false;
	}
	var testNum ="["+(sentenceIndex+1)+"/"+subjects.length+"]";
	$("#testNum").html(testNum);
	transSentenceData(subject);
	sentenceIndex += 1;
}

function keepGoing(){
	$('[data-relax]').css('display', 'none');
	$('#operatorBtn').find('input').removeAttr("disabled");
	getSubjects();
	$(this).data('index', 0);
	console.log("KeepGoing");
	$("#askToRest").modal('hide');
}

var watcher = null;
$(document).ready(function () {
	getSubjects();
	var stopwatchArr = new Array();
	$nextWorkBtn.click(function () {
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
				var time = {
					"key": key,
					"value": now - watcher
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
			var time = {
				"key": key,
				"value": now - watcher
			}
			stopwatchArr.push(time);
			// 在最后一个单词的时候回获取不了下面的数据
				score.paper = curSentence.paper;
				score.subType = curSentence.type;
			$('.question-area').css('display', '');
			$('#question').text(curSentence.question);
		}
	});

	$('#submit').click(function () {
		var chk = $('input[name="answer"]:checked').val();
		if (chk === curSentence.answer) {
			score.correct = 1;
		} else {
			score.correct = 0;
		}
		var valueAsStr = "";
		var len = stopwatchArr.length;
		
		var myTemp = new Array();
		for (var i = 0; i < len; i++) {
			var temp = stopwatchArr[i];
			var obj= new Object();
			obj[temp.key] = temp.value;
			myTemp.push(obj);
		}
		score.stopwatch = JSON.stringify(myTemp);
		$.post('/score/save', score, function (data) {
			if (data.status !== 1) {
				sysTips(data.message);
			} else {
				// 判断是否显示全句,然后间隔5秒后显示下一题
				if (currentPaperNum == 2 || currentPaperNum == 3) {
					// 显示句子全部,并在5秒跳转
					for (var i in words) {
						$('[data-work-index="' + i + '"]').append(words[i]);
					}
					setTimeout(() => {
						stopwatchArr = new Array();
						nextSentence();
					}, showOriginSentenceSeconds * 1000);
				} else {
					stopwatchArr = new Array();
					nextSentence();
				}
			}
		}, "json");
		return false;
	});

//	$relaxBtn.click(function () {
//		
//		console.log($(this).data('relax-btn'));
//		
//		if ($(this).data('relax-btn')) {
//			// 点击休息 do something
//		} else {
//			$('[data-relax]').css('display', 'none');
//			$('#operatorBtn').find('input').removeAttr("disabled");
//			getSubjects();
//			$(this).data('index', 0);
//		}
//	});
	

});