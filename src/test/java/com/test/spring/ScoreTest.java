package com.test.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.official.App;
import com.official.entity.Score;
import com.official.service.score.ScoreService;
import com.official.util.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class ScoreTest {

	@Autowired
	private ScoreService scoreService;

	@Test
	public void save() {
		Score score = new Score();
		score.setCorrect(1);
		score.setCusId(1);
		score.setSubId(1);
		score.setPaper(1);
		score.setSubType(1);

		List<Map<String, Integer>> timeList = new ArrayList<>();

		Map<String, Integer> stopwatch1 = new HashMap<String, Integer>();
		stopwatch1.put("a", 1);

		Map<String, Integer> stopwatch2 = new HashMap<String, Integer>();
		stopwatch2.put("a", 1);

		Map<String, Integer> stopwatch3 = new HashMap<String, Integer>();
		stopwatch3.put("a", 1);

		timeList.add(stopwatch1);
		timeList.add(stopwatch2);
		timeList.add(stopwatch3);

		score.setStopwatch(JsonUtil.toJSONStr(timeList));

		scoreService.insert(score);

	}

}
