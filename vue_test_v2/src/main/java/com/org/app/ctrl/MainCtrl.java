package com.org.app.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.app.mapper.MainDao;
import com.org.app.vo.User;

@Controller
public class MainCtrl {
	@Autowired
	MainDao mainDao;
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/user") // requestmapping method=RequestMethod.GET가 포함되어 있다.
    @ResponseBody
	public List<User> getUserList() throws Exception {
		return mainDao.getUserList();
	}
}
