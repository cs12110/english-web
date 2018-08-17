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
import com.official.enums.StatusEnum;
import com.official.service.customer.CustomerService;
import com.official.util.Const;
import com.official.util.StrUtil;

/**
 * 用户控制类
 *
 * <p>
 * detailed comment
 * 
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/customer/")
public class CustomerCtrl {

	private static Logger logger = LoggerFactory.getLogger(CustomerCtrl.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * 保存用户信息,如果学号已经存在,则改为登录
	 * 
	 * @param req
	 * @param customer
	 *            用户信息
	 * @return String
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest req, Customer customer) {
		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		if (StrUtil.isEmpty(customer.getCode())) {
			reply.setStatus(StatusEnum.FAILURE.getValue());
			reply.setMessage("学号不能为空");
			return reply.toString();
		}

		Customer search = new Customer();
		search.setCode(customer.getCode());
		Customer target = customerService.selectOne(search);
		if (null == target) {
			logger.info("Save customer:{}", customer.getCode());
			customerService.insert(customer);
			reply.setMessage("新增成功");
		} else {
			logger.info("Already exists customer:{}", target.getCode());
			customer = target;
			reply.setMessage("登录成功");
		}

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
	@RequestMapping("loginCheck")
	@ResponseBody
	public String checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object user = session.getAttribute(Const.CURRENT_USER);

		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		if (null == user) {
			reply.setStatus(StatusEnum.FAILURE.getValue());
			reply.setMessage("请先登录");
		}

		return reply.toString();
	}

	/**
	 * 检查用户是否登陆
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("logout")
	@ResponseBody
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute(Const.CURRENT_USER, null);

		Reply reply = new Reply(StatusEnum.SUCCESS.getValue());
		return reply.toString();
	}
}
