package com.official.ctrl.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Customer;
import com.official.entity.reply.Reply;
import com.official.enums.ReplyEnum;
import com.official.service.customer.CustomerService;
import com.official.util.Const;

@Controller
@RequestMapping("/customer/")
public class CustomerCtrl {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/html")
	public String toHtml() {
		return "/customer/info";
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest req, Customer customer) {

		customerService.insert(customer);

		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		reply.setMessage("新增成功");
		reply.setData(customer);

		HttpSession session = req.getSession();
		session.setAttribute(Const.CURRENT_USER, customer);
		return reply.toString();
	}

}
