package com.official.ctrl.score;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Customer;
import com.official.entity.Score;
import com.official.entity.reply.Reply;
import com.official.enums.ReplyEnum;
import com.official.service.score.ScoreService;
import com.official.util.Const;

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
	public String save(HttpServletRequest req, Score score) {

		HttpSession session = req.getSession();
		Customer currentUser = (Customer) session.getAttribute(Const.CURRENT_USER);
		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		reply.setMessage("添加成功");

		if (currentUser == null) {
			reply.setStatus(ReplyEnum.FAILURE.getValue());
			reply.setMessage("请先填写用户信息");
		} else {
			score.setCusId(currentUser.getId());
			scoreService.insert(score);
		}

		return reply.toString();
	}

}
