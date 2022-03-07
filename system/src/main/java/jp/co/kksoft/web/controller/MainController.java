package jp.co.kksoft.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kksoft.web.entity.BokuEntity;
import jp.co.kksoft.web.mapper.RigsterMapper;
import jp.co.kksoft.web.model.RegisterModel;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("web")
@Slf4j
public class MainController {
	
	@Autowired
	private RigsterMapper rigsterMapper;

	@GetMapping("register")
	public String init (@ModelAttribute RegisterModel registerModel, Model model) {
		
		return "register";
	}
	
	@PostMapping("doRegister")
	public String doRigister (RegisterModel registerModel, Model model) {
		
		log.info("{}",registerModel);
		rigsterMapper.creatUser(registerModel);
		
		return "login";
	}
	
	@PostMapping("doLogin")
	public String doLogin (RegisterModel registerModel, Model model) {
		
		log.info("{}",registerModel);
	int keka = rigsterMapper.checkLogin(registerModel);
	
	if(keka == 0) {
		return "login";
	}else {
	List<BokuEntity> allUserList =	rigsterMapper.getAllUserList();
	model.addAttribute("userList",allUserList);
		return "logined";
	}
	}
	
}
