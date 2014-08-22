package br.com.opinerama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.opinerama.dao.generic.BaseEntity;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements BaseEntity<Long> {

	private static final long serialVersionUID = -4128538971030460605L;

	@Id
	@SequenceGenerator(name = "sequeceFornGen", sequenceName = "seq_fornecedor", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequeceFornGen")
	@Column(name = "id_fornecedor")
	private Long id;

	@NotNull
	@Column(name = "razao_social")
	private String razaoSocial;

	@NotNull
	@Column(name = "nome_fantasia")
	private String nomeFantasia;

	@NotNull
	@Column(name = "cnpj")
	private String cnpj;

	@Column(name = "senha")
	private String senha;

	@Column(name = "cep")
	private String cep;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "numero")
	private Long numero;

	@NotNull
	@Column(name = "responsavel")
	private String responsavel;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "ativo")
	private Boolean ativo = true;

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
