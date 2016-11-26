package br.com.fiap.aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.helper.ClientesHelper;

public class ClientesTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aula_JPA_Exercicio1");
		EntityManager em = emf.createEntityManager();
		
		ClientesHelper dao = new ClientesHelper(em);
		
		Clientes cliente = new Clientes();
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Infome o id do cliente"));
		String name = JOptionPane.showInputDialog("Infome o nome do cliente");
		String email = JOptionPane.showInputDialog("Informe o email do cliente");

		cliente.setId(id);
		cliente.setEmail(name);
		cliente.setNome(email);
		
		JOptionPane.showMessageDialog(null, dao.salvar(cliente));
		
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja vincular um pedido à esse cliente?");
		if(opcao == JOptionPane.YES_OPTION){
			try {
			Pedidos pedido = new Pedidos();
			
			int pedidoId = Integer.parseInt(JOptionPane.showInputDialog("Infome o número do pedido"));
			String descricao = JOptionPane.showInputDialog("Infome a descição do pedido");
			double valor = Double.parseDouble(JOptionPane.showInputDialog("Infome o valor pedido"));
			
				Date date = new SimpleDateFormat("dd/MM/yyyy")
						.parse(JOptionPane.showInputDialog("Infome a data do pedido"));
				
				pedido.setId(pedidoId);
				pedido.setDescricao(descricao);
				pedido.setData(date);
				pedido.setValor(valor);
				
				System.out.println(dao.vinculaPedido(cliente.getId(), pedido));
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}

	}

}
