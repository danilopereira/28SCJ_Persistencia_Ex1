package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class ClientesHelper {
	
	EntityManager em;
	
	public ClientesHelper(EntityManager em) {
		this.em = em;
	}
	
	public String salvar(Clientes cliente){
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		return "Cliente salvo!"; 
	}
	
	public String vinculaPedido(int clienteId, Pedidos pedido){
		Clientes cliente = em.find(Clientes.class, clienteId);
		cliente.getPedidos().add(pedido);
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		return "Pedido Vinculado";
	}
	
	
}
