package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cliente", fetch=FetchType.LAZY)
	private List<Pedidos> pedidos = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pedidos> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	
	@Override
	public String toString() {
		return "Clientes {\"id\":\"" + id + "\", \"nome\":\"" + nome + "\", \"email\":\"" + email + "\", \"pedidos\":\""
				+ pedidos + "\"}";
	}
	
	
	
	

}
