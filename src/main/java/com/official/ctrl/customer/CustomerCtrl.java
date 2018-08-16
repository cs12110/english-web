package com.official.ctrl.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Customer;
import com.official.entity.reply.Reply;
import com.official.enums.ReplyEnum;
import com.official.service.customer.CustomerService;
import com.official.util.Const;
import com.official.util.StrUtil;

@Controller
@RequestMapping("/customer/")
public class CustomerCtrl {

	private static Logger logger = LoggerFactory.getLogger(CustomerCtrl.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/html")
	public String toHtml() {
		return "/customer/info";
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest req, Customer customer) {
		Reply reply = new Reply();
		if (StrUtil.isEmpty(customer.getCode())) {
			reply.setStatus(ReplyEnum.FAILURE.getValue());
			reply.setMessage("学号不能为空");
			return reply.toString();
		}

		Customer search = new Customer();
		search.setCode(customer.getCode());
		Customer target = customerService.selectOne(search);
		if (null == target) {
			logger.info("Save customer:{}" + customer.getCode());
			customerService.insert(customer);
		} else {
			logger.info("Already exists customer:{}" + target.getCode());
			customer = target;
		}

		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		reply.setMessage("新增成功");
		reply.setData(customer);

		HttpSession session = req.getSession();
		session.setAttribute(Const.CURRENT_USER, customer);
		return reply.toString();
	}

	/**
	 * 检查用户是否登陆
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("checkLogin")
	@ResponseBody
	public String checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object user = session.getAttribute(Const.CURRENT_USER);

		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());

		if (null == user) {
			reply.setStatus(ReplyEnum.FAILURE.getValue());
			reply.setMessage("请先登录");
		}

		return reply.toString();
	}
}
