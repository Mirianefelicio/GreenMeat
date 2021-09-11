package modelo.entidades.produtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import modelo.entitidades.usuarios.Fornecedor;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;

	@Column(name = "quantidade", nullable = false, unique = false)
	private float quantidade; // em kg, por isso float.

	@Column(name = "valorTotal", nullable = false, unique = false)
	private float valorTotal; // Esse atributo nos permite acessar o valor total de um item, que � calculado a
								// partir do pre�o de um produto * quantidade

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido")
	Pedido pedido;
	
	
	public Item() {
	}

	public Item(Produto produto, float quantidade) {
		setProduto(produto);
		setQuantidade(quantidade);
		setValorTotal(calculaValorTotal());
	}

	public Produto getProduto() {
		return produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public float calculaValorTotal() {
		return this.produto.getPrecoVenda() * quantidade;
	}
}
