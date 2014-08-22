package br.com.opinerama.dao;

import java.text.Normalizer;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.opinerama.dao.generic.JPADAO;
import br.com.opinerama.dao.impl.ProdutoDAO;
import br.com.opinerama.exception.DAOException;
import br.com.opinerama.model.Produto;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("produtoDao")
public class JPAProduto extends JPADAO<Produto, Long> implements ProdutoDAO{

	protected Class<Produto> clazz;

	@Override
	protected Class<Produto> getClazz() {
		return Produto.class;
	}
	
	public List<Produto> getProdutosPorCategoria(Long id) throws DAOException {
		try {
			TypedQuery<Produto> query = this.em.createQuery("select p from " + Produto.class.getSimpleName() + " p where p.categoria.id = :idCategoria", Produto.class);
			query.setParameter("idCategoria", id);
			List<Produto> lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public List<Produto> buscarPordutoPorNome(String nome, Long categoriaSuperPai) throws DAOException{
		try {
			
			String parametro = Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
			
			String condicao = "";
			if(categoriaSuperPai > 0){
				condicao += " and p.categoria.superPai = :idCategoria";
			}
			
			TypedQuery<Produto> query = this.em.createQuery("select p from "+Produto.class.getSimpleName()+" p where upper(TRANSLATE(p.nome,'ÀÁáàÉÈéèÍíÓóÒòÚú','AAaaEEeeIiOoOoUu')) like :nome "+condicao+"", Produto.class);
			
			if(categoriaSuperPai > 0){
				query.setParameter("idCategoria", categoriaSuperPai);
			}
			if(nome == null){
				nome = "";
			}
			query.setParameter("nome", "%"+parametro+"%");
			return query.getResultList();
		} catch (Exception e) {
			throw new DAOException("Erro ao consultar produto", e);
		}
		
	}
	
}
