package modelo.entidades.produtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.dao.estoque.EstoqueDAO;
import modelo.dao.estoque.EstoqueDAOImpl;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList();

	public void adicionarProdutoAoEstoque(Produto produto) {
		
		EstoqueDAO estoqueDAO = new EstoqueDAOImpl();
		
		Estoque estoque = (Estoque) estoqueDAO.recuperarEstoque();
		if (getItens().contains(produto) == false) {
			getItens().add(new Item(produto, 0));
		}
	}

	public void adicionarAoEstoque(Item item) {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

//	falta mencionar estoque na classe item
//	@OneToMany(fetch = FetchType.LAZY,mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Estoque> itens = new ArrayList<Estoque>();

//	
//	public List<Estoque> getItens() {
//		return itens;
//	}

//	falta relaciona
//	public void setItens(List<Estoque> itens) {
//		this.itens = itens;
//	}

	// para aumentar a quantidade de um item em estoque deve-se acessar diretamente
	// esse item, por exemplo item1.setQuantidade(quantidade);

//	public void adicionarAoEstoque(Estoque item) {
//		itens.add(item);
//	}

}
