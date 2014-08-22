package br.com.opinerama.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.opinerama.dao.impl.CategoriaDAO;
import br.com.opinerama.dao.impl.ProdutoDAO;
import br.com.opinerama.exception.DAOException;
import br.com.opinerama.model.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@RequestMapping(value = "/resultados", method = RequestMethod.POST)
	public ModelAndView pesquisaProdutos(String nome) throws DAOException{
		Map<String, Object> params = consultarProduto(nome, 0l);
		ModelAndView mav = new ModelAndView("produto/pesquisaProduto", params);
		return mav;
	}
	
	@RequestMapping(value = "listaProduto/termo/{nome}/categoria/{categoriaSuperPai}", method = RequestMethod.GET)
	public ModelAndView listaProdutos(@PathVariable String nome, @PathVariable Long categoriaSuperPai) throws DAOException{
		Map<String, Object> params = consultarProduto(nome, categoriaSuperPai);
		ModelAndView mav = new ModelAndView("produto/listaProdutos", params);
		return mav;
	}
	
	private Map<String, Object> consultarProduto(String nome, Long categoriaSuperPai)throws DAOException{
		Map<String, Object> params = new LinkedHashMap<String, Object>();  
		List<Produto> produtos = produtoDAO.buscarPordutoPorNome(nome, categoriaSuperPai);
		params.put("categorias", categoriaDAO.listaCategoriasPai());
		params.put("listaProdutos", produtos);
		params.put("totalProdutos", produtos.size());
		params.put("texto"," produto(s) encontrado(s) com o termo: "+nome);
		return params;
	}
	
	
//	@RequestMapping(value = "/nome/{nome}/categoria/{categoriaSuperPai}", method = RequestMethod.GET)
//	public ModelAndView perfilProduto(@RequestBody String nome, Long categoriaSuperPai) throws DAOException{
//		Map<String, Object> params = new LinkedHashMap<>();
//		List<Categoria> categorias =  categoriaDAO.listaCategoriasPai();
//		params.put("categorias", categorias);
//		categoriaSuperPai = categoriaSuperPai == null ? 0l : categoriaSuperPai;
//		List<Produto> listaProduto = produtoDAO.buscarPordutoPorNome(nome, categoriaSuperPai);
//		params.put("listaProdutos", listaProduto);
//		params.put("totalProdutos", listaProduto.size());
//		ModelAndView mav = new ModelAndView("produto/perfilProduto", params);
//		return mav;
//	}

}
