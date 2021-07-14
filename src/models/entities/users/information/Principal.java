package models.entities.users.information;

import java.time.LocalDate;

import models.entities.products.Item;
import models.entities.products.Produto;
import models.entities.products.Tipo;
import models.entities.users.Cliente;
import models.entities.users.Fornecedor;

public class Principal {
	public static void main(String[] args) {

		Endereco endereco1 = new Endereco("Rua", "Rua Primeiro de Janeiro", "logradouro", 18, 93234123, "Casa");

		Localidade localidade1 = new Localidade("Estados Unidos", "Florida", "Talahasse", "America do Norte",
				endereco1);

		Produto produto1 = new Produto("Picanha", "Este produto � muito gostoso, compre ele", Tipo.BOVINO, 22);
		Produto produto2 = new Produto("Peito de Frango", "Este produto � muito gostoso, compre ele", Tipo.AVE, 16);
		Produto produto3 = new Produto("Costeleta", "Este produto � muito gostoso, compre ele", Tipo.OVINO, 30);

		Contato contato4 = new Contato("emailzinho4@gmail.com", "2435-4242");

		Fornecedor fornecedor1 = new Fornecedor("Somos uma empresa fundamentada e vendemos carne", "111.222.333.21",
				localidade1, "MeuLogin1", "MinhaSenhaSecreta", contato4);

		Contato contato1 = new Contato("emailzinho1@gmail.com", "2294-2344");
		Contato contato2 = new Contato("emailzinho2@gmail.com", "4354-5233");
		Contato contato3 = new Contato("emailzinho3@gmail.com", "2544-3534");

		Cliente cliente1 = new Cliente("Carlos", "111.332.786-12", LocalDate.of(16, 2, 2000), localidade1, "2222-3245",
				"MeuLogin2", "MinhaSenha2 ", contato1);
		Cliente cliente2 = new Cliente("Jos�", "154.342.123-64", LocalDate.of(12, 5, 1993), localidade1, "3422-3546",
				"MeuLogin3", "MinhaSenha3 ", contato2);
		Cliente cliente3 = new Cliente("Marta", "100.655.448-21", LocalDate.of(22, 7, 1983), localidade1, "3222-6448",
				"MeuLogin4", "MinhaSenha4 ", contato3);

		// pedido, item e contato

		// como funciona o item?
		Item item1 = new Item();

//		------------------------------------------	
//		Cliente cliente1 = new Cliente("Carlos", "155.555.224-22", "21/02/2000", "Rua dos bobos", "3332-1584",
//				"login", "senha", "Carlinhos@gmail.com" );
//		
//		
//		ListaDeCompras lista1 = new ListaDeCompras( cliente1);
//		
//		lista1.adicionarProduto(produto1);
//		
//		System.out.println(lista1.getValorTotal());
//		System.out.println(lista1.getQuantidadeDeProdutos());
//		System.out.println(lista1.getCliente());
	}

}
