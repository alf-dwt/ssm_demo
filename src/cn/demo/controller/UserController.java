package cn.demo.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.demo.mapper.UserMapper;
import cn.demo.model.User;

@Controller("userController")
@Scope("prototype")
public class UserController {
	private UserMapper userMapper;
	
	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@RequestMapping(value="/user/insert",method=RequestMethod.POST)
	public String add(User user){
		userMapper.insertUser(user);
		return "success";
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String get(@PathVariable int id){
		User u = userMapper.getUser(id);
		System.out.println("姓名:" + u.getUname() + ",性别:" + u.getGender() + ",年龄:" + u.getAge());
		return "get";
	}
	
	@RequestMapping(value="/addPage",method=RequestMethod.GET)
	public String index(){
		return "add";
	}
}
