package br.com.opinerama.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.opinerama.dao.generic.JPADAO;
import br.com.opinerama.dao.impl.CategoriaDAO;
import br.com.opinerama.exception.DAOException;
import br.com.opinerama.model.Categoria;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("categoriaDao")
public class JPACategoria extends JPADAO<Categoria, Long> implements CategoriaDAO{

	protected Class<Categoria> clazz;

	@Override
	protected Class<Categoria> getClazz() {
		return Categoria.class;
	}

	
	@Override
	public List<Categoria> list() throws DAOException {
		try {
			TypedQuery<Categoria> query = this.em.createQuery("select c from " + Categoria.class.getSimpleName() + " c order by c.id asc", Categoria.class);
			List<Categoria> lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public List<Categoria> listaCategoriasPai() throws DAOException {
		try {
			TypedQuery<Categoria> query = this.em.createQuery("select c from " + Categoria.class.getSimpleName() + " c where c.categoriaPai is null order by c.id asc", Categoria.class);
			List<Categoria> lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
}
