package br.com.opinerama.model;

import java.io.Serializable;
import java.net.URI;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.opinerama.dao.generic.BaseEntity;

@Entity
@Table(name = "produto_servico")
public class Produto implements BaseEntity<Long>, Serializable {

	private static final long serialVersionUID = 703428872189698267L;

	@Id
	@SequenceGenerator(name = "sequeceProdGen", sequenceName = "seq_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequeceProdGen")
	@Column(name = "id_produto")
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "foto")
	private String foto;
	
//	@Transient
//	private UploadedFile documento;

	@Column(name = "telefone_sac")
	private String telefoneSac;

	@NotNull
	@Column(name = "email")
	private String email;

	@Column(name = "link_hotsite")
	private String hotsite;

	@NotNull
	@Column(name = "ativo")
	private Boolean ativo = true;

	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public URI getFoto() {
		if(foto == null) return null;
		return URI.create(foto);
	}

	public void setFoto(URI foto) {
		this.foto = foto == null ? null : foto.toString();
	}

	public String getTelefoneSac() {
		return telefoneSac;
	}

	public void setTelefoneSac(String telefoneSac) {
		this.telefoneSac = telefoneSac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHotsite() {
		return hotsite;
	}

	public void setHotsite(String hotsite) {
		this.hotsite = hotsite;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
