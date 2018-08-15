package com.official.ctrl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.entity.Customer;
import com.official.entity.reply.Reply;
import com.official.enums.ReplyEnum;
import com.official.service.customer.CustomerService;

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
	public String save(Customer customer) {

		customerService.insert(customer);

		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		reply.setMessage("新增成功");
		reply.setData(customer);
		return reply.toString();
	}

}
