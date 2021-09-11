package modelo.dao.fornecedor;

import java.util.List;

import modelo.entidades.produtos.Produto;
import modelo.entitidades.usuarios.Fornecedor;

public interface FornecedorDAO {

	void inserirFornecedor(Fornecedor fornecedor);
	
	void deletarFornecedor(Fornecedor fornecedor);

	void atualizarFornecedor(Fornecedor fornecedor);
	
	Fornecedor recuperarPorId(Long id);
	
	Fornecedor recuperarFornecedorProduto(Produto produto);
	
	List<Fornecedor>recuperarFornecedores();
	
}