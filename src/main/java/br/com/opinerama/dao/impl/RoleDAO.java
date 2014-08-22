package br.com.opinerama.dao.impl;

import br.com.opinerama.dao.generic.DAOBase;
import br.com.opinerama.model.Role;

public interface RoleDAO extends DAOBase<Role, Long>{
	
	public Role buscarRole(String nome);

}
