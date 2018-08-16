package com.official.ctrl.sys;

import com.official.entity.Customer;
import com.official.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sing on 2018/8/16.
 *
 * @Author Lucien
 * desc:页面控制类
 */
@Controller
@RequestMapping(value = "/customer")
public class PageCtrl {


    /**
     * 答题页面
     *
     * @return
     */
    @GetMapping(value = "/exam")
    public String exam(HttpServletRequest request) {

        Customer customer = (Customer) request.getSession().getAttribute(Const.CURRENT_USER);

        if (null == customer)
            return "redirect:/customer/html";

        return "customer/exam";
    }


}
