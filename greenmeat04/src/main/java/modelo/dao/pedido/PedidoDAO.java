package modelo.dao.pedido;

import java.util.List;

import modelo.entidades.produtos.Pedido;
import modelo.entitidades.usuarios.Cliente;

public interface PedidoDAO {

	void inserirPedido(Pedido Pedido);

	void deletarPedido(Pedido pedido);

	void atualizarPedido(Pedido pedido);
	
	List<Pedido> recuperarPedidos();
	
	List<Pedido> recuperarPedidosCliente(Cliente cliente);
	
	/*
	 * List<Pedido> recuperarPedidoOrdenadosDataEntregaAscendente();
	 * 
	 * List<Pedido> recuperarPedidoOrdenadosDataEntregaDescendente();
	 * 
	 * List<Pedido> recuperarPedidoOrdenadosStatus();
	 * 
	 * List<Pedido> recuperarPedidoOrdenadosvalorTotalAscendente();
	 * 
	 * List<Pedido> recuperarPedidoOrdenadosvalorTotalDescendente();
	 */
}
