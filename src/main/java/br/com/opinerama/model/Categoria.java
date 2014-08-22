package br.com.opinerama.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import br.com.opinerama.dao.generic.BaseEntity;


@Entity
@Table(name = "categoria")
public class Categoria implements BaseEntity<Long>, Serializable {

	private static final long serialVersionUID = 6516667207339545557L;

	@Id
	@SequenceGenerator(name = "sequeceCatGen", sequenceName = "seq_categoria", allocationSize = 1)  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequeceCatGen")
	@Column(name = "id_categoria")
	private Long id;

//	@JsonIgnore
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "categoria_atributo", joinColumns = @JoinColumn(name = "id_categoria"), inverseJoinColumns = @JoinColumn(name = "id_atributo"))
	private List<Atributo> atributos;

	@Column(name = "id_categoria_pai")
	private Long categoriaPai;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "ativo")
	private Boolean ativo;
	
	@Column(name = "super_pai")
	private Long superPai;
	
	@Override
	public Long getId() {
		return id;
	}
	
	public Long getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Long categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

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

	public Long getSuperPai() {
		return superPai;
	}

	public void setSuperPai(Long superPai) {
		this.superPai = superPai;
	}
}
