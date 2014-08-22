package br.com.opinerama.dao.generic;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.opinerama.exception.DAOException;

@Transactional(propagation=Propagation.SUPPORTS)
public abstract class JPADAO<T extends BaseEntity<PK>, PK extends Serializable> implements DAOBase<T, PK> {

	protected abstract Class<T> getClazz();

	protected EntityManager em;

	public void delete(T t) throws DAOException {
		try {
			this.em.remove(t);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> find(List<? extends BaseEntity<PK>> entities) throws DAOException {
		if ((entities != null) && !entities.isEmpty()) {
			return this.find((T[]) entities.toArray(new BaseEntity[0]));
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> find(PK... ids) throws DAOException {
		if ((ids == null) || (ids.length == 0)) {
			return null;
		}

		try {
			TypedQuery<T> query = this.em.createQuery("from " + getClazz().getSimpleName() + " where id in(:ids)", getClazz());
			query.setParameter("ids", Arrays.asList(ids));
			List<T> list = query.getResultList();

			return list;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public T find(PK id) throws DAOException {
		try {
			return this.em.find(getClazz(), id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> find(T... entities) throws DAOException {
		if ((entities != null) && (entities.length > 0)) {
			PK[] ids = (PK[]) new Serializable[entities.length];
			for (int i = 0; i < ids.length; i++) {
				ids[i] = entities[i].getId();
			}

			return this.find(ids);
		} else {
			return null;
		}
	}

	public T insert(T t) throws DAOException {
		try {
			this.em.persist(t);
			return t;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<T> list() throws DAOException {
		try {
			TypedQuery<T> query = this.em.createQuery("from " + getClazz().getSimpleName() + " order by id desc", getClazz());
			List<T> list = query.getResultList();

			return list;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void refresh(T t) throws DAOException {
		try {
			this.em.refresh(t);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public EntityManager getEm() {
	    return em;
	}
	
    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

	public T update(T t) throws DAOException {
		try {
			t = this.em.merge(t);
			return t;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}