package com.htc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.htc.model.User;
import com.htc.service.BaseService;
import com.htc.utils.CommonUtils;

@Controller
public class BaseController {

	private BaseService baseService;

	public BaseService getBaseService() {
		return baseService;
	}

	@Autowired
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest request){
	    try{
	        User user = new User();
            user.setLoginName(request.getParameter("login_name"));
            user.setLoginPassword(request.getParameter("login_password"));
            String str = baseService.login(user);
            if(str.equalsIgnoreCase("success")){
                return "index";
            }else{
                return "result";
            }
	    }catch(Exception e){
            e.printStackTrace();
            return "result";
	    }
	}

	@SuppressWarnings("finally")
	@RequestMapping("addInfo")
	public String add(User user, HttpServletRequest request) {
		try {
			user.setUuid(CommonUtils.getUUID());
			user.setAddTime(CommonUtils.getNowTime());
			user.setLoginName(request.getParameter("login_name"));
			user.setLoginPassword(request.getParameter("login_password"));
			user.setNickName(request.getParameter("nick_name"));
			user.setRemark(request.getParameter("remark"));
			String str = baseService.addInfo(user);
			System.out.println(str);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"添加信息失败！具体异常信息：" + e.getMessage());
		} finally {
			return "result";
		}
	}

	@RequestMapping("getAll")
	public String getAddInfoAll(HttpServletRequest request) {
		try {
			List<User> list = baseService.getAll();
			System.out.println(list);
			request.setAttribute("addLists", list);
			return "listAll";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return "result";
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(String tid, HttpServletRequest request) {
		try {
			String str = baseService.delete(tid);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"删除信息失败！具体异常信息：" + e.getMessage());
		} finally {
			return "result";
		}
	}

	@RequestMapping("modify")
	public String modify(String tid, HttpServletRequest request) {
		try {
			User user = baseService.findById(tid);
			request.setAttribute("add", user);
			return "modify";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return "result";
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(User user, HttpServletRequest request) {
		try {
			user.setLoginName(request.getParameter("login_name"));
			user.setLoginPassword(request.getParameter("login_password"));
			user.setNickName(request.getParameter("nick_name"));
			user.setRemark(request.getParameter("remark"));
			String str = baseService.update(user);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"更新信息失败！具体异常信息：" + e.getMessage());
		} finally {
			return "result";
		}
	}

}
