package com.official.ctrl.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Score;
import com.official.entity.reply.Reply;
import com.official.enums.ReplyEnum;
import com.official.service.score.ScoreService;

@Controller
@RequestMapping("/score/")
public class ScoreCtrl {

	@Autowired
	private ScoreService scoreService;

	@RequestMapping("/saveBatch")
	@ResponseBody
	public String saveBatch(List<Score> list) {
		for (Score score : list) {
			scoreService.insert(score);
		}
		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		reply.setMessage("添加成功");

		return reply.toString();

	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(Score score) {

		scoreService.insert(score);

		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		reply.setMessage("添加成功");

		return reply.toString();
	}

}
