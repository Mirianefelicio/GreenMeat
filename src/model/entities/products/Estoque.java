package model.entities.products;

import java.util.List;

public class Estoque {

	
	private List <Item> itens;
//	este m�todo retorna apenas um endere�o de mem�ria
	
	public List <Item> getItens() {
		return itens;
	}

	public void setItens(List <Item> itens) {
		this.itens = itens;
	}
	
	
	
	
}
