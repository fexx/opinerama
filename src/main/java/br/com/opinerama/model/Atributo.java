package br.com.opinerama.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.opinerama.dao.generic.BaseEntity;


@Entity
@Table(name = "atributo")
public class Atributo implements BaseEntity<Long>{

	private static final long serialVersionUID = 536789763646317025L;

	@Id
	@SequenceGenerator(name = "sequeceAtributoGen", sequenceName = "seq_atributo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequeceAtributoGen")
	@Column(name = "id_atributo")
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "ativo")
	private Boolean ativo;

	@ManyToMany(mappedBy = "atributos")
	private List<Categoria> categorias;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

}
