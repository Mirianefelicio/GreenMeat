package modelo.dao.estoque;

import java.util.List;

import modelo.entidades.produtos.Estoque;
import modelo.entidades.produtos.Item;

public interface EstoqueDAO {

	void inserirEstoque(Estoque estoque);
	
	void deletarEstoque(Estoque estoque);
	
	void atualizarEstoque(Estoque estoque);
	
	List<Estoque>recuperarEstoque();
}
