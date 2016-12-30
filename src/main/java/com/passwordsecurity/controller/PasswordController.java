package com.passwordsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.passwordsecurity.model.Senha;

@Controller
public class PasswordController {
	
	@RequestMapping("/home")
	public ModelAndView home(){ 
		Senha senha = new Senha();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("senha", senha);
		return mv;
	}
	
	@RequestMapping(value="/home" , method = RequestMethod.POST)
	public ModelAndView home(Senha password){ 
		System.out.println(password.getDsSenha());
		ModelAndView mv = new ModelAndView("index");
		password.calcular();
		mv.addObject("senha", password);		
		return mv;
	}
	
	@RequestMapping(value="/verificarsenha" , method = RequestMethod.POST)
	public @ResponseBody Senha verificarSenha(Senha password){ 
		System.out.println(password.getDsSenha());
		password.calcular();
		return password;
	}
}
