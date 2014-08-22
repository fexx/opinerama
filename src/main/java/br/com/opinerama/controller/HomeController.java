package br.com.opinerama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.opinerama.dao.impl.CategoriaDAO;
import br.com.opinerama.dao.impl.RoleDAO;

@Controller
public class HomeController {
	
	@Autowired
	private RoleDAO daoRole;
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() throws Exception{
        return new ModelAndView("home");
	}

}
