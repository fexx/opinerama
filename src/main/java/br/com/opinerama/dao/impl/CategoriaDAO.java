package br.com.opinerama.dao.impl;

import java.util.List;

import br.com.opinerama.dao.generic.DAOBase;
import br.com.opinerama.exception.DAOException;
import br.com.opinerama.model.Categoria;

public interface CategoriaDAO extends DAOBase<Categoria, Long>{
	
	public List<Categoria> listaCategoriasPai() throws DAOException;
	
}
