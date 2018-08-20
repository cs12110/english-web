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
import com.official.enums.StatusEnum;
import com.official.service.score.ScoreService;
import com.official.util.Const;

/**
 * 成绩控制类
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/score/")
public class ScoreCtrl {

	@Autowired
	private ScoreService scoreService;

	/**
	 * 批量保存
	 * 
	 * @param list
	 *            list
	 * @return String
	 */
	@RequestMapping("/saveBatch")
	@ResponseBody
	public String saveBatch(List<Score> list) {
		for (Score score : list) {
			scoreService.insert(score);
		}
		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		reply.setMessage("添加成功");

		return reply.toString();

	}

	/**
	 * 保存成绩
	 * 
	 * @param req
	 *            请求
	 * @param score
	 *            成绩
	 * @return String
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest req, Score score) {

		HttpSession session = req.getSession();
		Customer currentUser = (Customer) session.getAttribute(Const.CURRENT_USER);
		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		reply.setMessage("添加成功");

		if (currentUser == null) {
			reply.setStatus(StatusEnum.FAILURE.getValue());
			reply.setMessage("请先填写用户信息");
		} else {
			// String stopwatchValue = StopwatchUtil.flat(score.getStopwatch());
			// score.setStopwatch(stopwatchValue);
			score.setCusId(currentUser.getId());
			scoreService.insert(score);
		}

		return reply.toString();
	}

}
