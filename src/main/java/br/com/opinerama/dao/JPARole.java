package br.com.opinerama.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.opinerama.dao.generic.JPADAO;
import br.com.opinerama.dao.impl.RoleDAO;
import br.com.opinerama.model.Role;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("roleDao")
public class JPARole extends JPADAO<Role, Long> implements RoleDAO{

	protected Class<Role> clazz;
	
	@Override
	public Role buscarRole(String nome) {
		Query query = em.createQuery("from Role usr where usr.nome = :nome");
		query.setParameter("nome", nome);
		return (Role) query.getSingleResult();
	}

	@Override
	protected Class<Role> getClazz() {
		return Role.class;
	}
	
}
