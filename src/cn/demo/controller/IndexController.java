package cn.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("index")
@Scope("prototype")
public class IndexController {
	
	@RequestMapping(value="/example/{msg}",method=RequestMethod.GET)
	public String example(@PathVariable String msg,Model model){
		model.addAttribute("msg", msg);
		return "msg";
	}
}
