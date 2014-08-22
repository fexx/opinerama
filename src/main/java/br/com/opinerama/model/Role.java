package br.com.opinerama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.opinerama.dao.generic.BaseEntity;


@Entity
@Table(name = "Role")
public class Role implements BaseEntity<Long>{
	
	private static final long serialVersionUID = -6170264530293591579L;

	@Id
	@SequenceGenerator(name = "sequeceRoleGen", sequenceName = "seq_role", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequeceRoleGen")
	@Column(name = "id_role")
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Override
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
