package br.com.opinerama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.opinerama.dao.impl.CategoriaDAO;
import br.com.opinerama.exception.DAOException;
import br.com.opinerama.model.Categoria;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public ModelAndView categoria() throws DAOException {
		ModelAndView view = new ModelAndView("categoria");
		return view;
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody List<Categoria> categorias() throws DAOException {
		return categoriaDAO.list();
	}
	
}
