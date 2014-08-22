package br.com.opinerama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "categoria_atributo")
public class CategoriaAtributo {


	@Id
	@SequenceGenerator(name = "sequeceCategroiaAtributoGen", sequenceName = "seq_categoria_atributo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequeceCategroiaAtributoGen")
	@Column(name = "id_categoria_atributo")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToOne
	@JoinColumn(name = "id_atributo")
	private Atributo atributo;
	
	public Long getId() {
		return id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
