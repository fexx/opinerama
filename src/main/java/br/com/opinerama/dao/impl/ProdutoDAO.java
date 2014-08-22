package br.com.opinerama.dao.impl;

import java.util.List;

import br.com.opinerama.dao.generic.DAOBase;
import br.com.opinerama.exception.DAOException;
import br.com.opinerama.model.Produto;

public interface ProdutoDAO extends DAOBase<Produto, Long>{
	
	public List<Produto> getProdutosPorCategoria(Long id) throws DAOException;
	
	public List<Produto> buscarPordutoPorNome(String nome, Long categoriaSuperPai) throws DAOException;

}
