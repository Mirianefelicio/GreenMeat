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
