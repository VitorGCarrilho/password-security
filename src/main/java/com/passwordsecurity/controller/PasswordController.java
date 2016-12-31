package com.passwordsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.passwordsecurity.model.Senha;

@Controller
public class PasswordController {
	
	@RequestMapping("/")
	public ModelAndView home(){ 
		Senha senha = new Senha();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("senha", senha);
		return mv;
	}
	
	@RequestMapping(value="/verificarsenha" , method = RequestMethod.POST)
	public @ResponseBody Senha verificarSenha(Senha password){ 
		password.calcular();
		return password;
	}	
}
