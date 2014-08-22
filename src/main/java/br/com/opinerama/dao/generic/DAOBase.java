package br.com.opinerama.dao.generic;

import java.util.List;

import br.com.opinerama.exception.DAOException;


public interface DAOBase<T, PK> {
	
	public List<T> list() throws DAOException;
	
	public T insert(T objeto) throws DAOException;
	
	@SuppressWarnings("unchecked")
	public List<T> find(PK... ids) throws DAOException;
	
	public List<T> find(List<? extends BaseEntity<PK>> entities) throws DAOException;
	
	public T find(PK id) throws DAOException;
	
	public void delete(T t) throws DAOException;
	
	public T update(T t) throws DAOException;
	
	public void refresh(T t) throws DAOException;
	
}
