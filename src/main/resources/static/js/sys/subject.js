/**
 * 分页对象
 */
var page = {
	index : 0,
	rows : 20
};

var subjectIndex = 0;
var subjects = [];
var stopwatch = {};

$(function() {
	getSubjects();
})

function nextTest() {
	getSubjects();
}

function getSubjects() {
	$.ajax({
		url : "/subject/list",
		data : {
			"page" : page.index,
			"rows" : page.rows
		},
		dataType : "json",
		success : function(data) {
			page.index = page.index + 1;
			subjects = data;
			// 开始从第一个显示
			nextSentence();
		}
	})
}

var wordArr = [];
var wordIndex = 0;
function nextSentence() {
	wordArr = getWordsOfSentence(subjectIndex);
	wordIndex = 0;
	//subjectIndex++;
}

/**
 * 显示词
 * 
 * @returns
 */
function nextWord() {
	var element = $(".each-word");
	var wholeArea = "";

	for (var index = 0, len = wordArr.length; index < len; index++) {
		var div = "";
		if (index != wordIndex) {
			div = "<div class=\"show-word\"></div>";
		} else {
			div = "<div class=\"show-word\">" + wordArr[index] + "</div>";
		}
		wholeArea += div;
	}
	element.html(wholeArea);
	wordIndex++;
	if (wordIndex >= wordArr.length) {
		wordIndex = wordArr.length;
		var subject = subjects[subjectIndex];
		$("#question").html(subject.question);
		$(".question-area").show();
	}
}

function getWordsOfSentence(sid) {
	var subject = subjects[sid];
	var sentence = subject.sentence;
	var words = sentence.split(" ");
	return words;
}