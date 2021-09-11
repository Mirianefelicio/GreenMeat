package model.dao.produto;

//import java.time.LocalDate;
import java.util.List;

import model.entities.products.Item;
import model.entities.products.Produto;

public interface ProdutoDAO {

	void inserirProduto(Produto produto);

	void deletarProduto(Produto produto);

	void atualizarProduto(Produto produto);

	Produto recuperarPorId(Long id);

	Produto recuperarProdutoItem(Item item);

			


//	List<Produto> recuperarPorCategoria(Produto produto);


	List<Produto> recuperarProdutos();

	List<Produto>recuperarPorCategoria(String categoria);
}
