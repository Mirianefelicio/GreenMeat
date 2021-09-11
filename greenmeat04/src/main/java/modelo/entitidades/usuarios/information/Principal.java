package modelo.entitidades.usuarios.information;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.exception.users.information.CountryInvalidException;
import model.exception.users.information.EmailInvalidException;
import model.exception.users.information.PhoneNumberInvalidException;
import modelo.dao.cliente.ClienteDAO;
import modelo.dao.cliente.ClienteDAOImpl;
import modelo.dao.contato.ContatoDAO;
import modelo.dao.contato.ContatoDAOImpl;
import modelo.dao.endereco.EnderecoDAO;
import modelo.dao.endereco.EnderecoDAOImpl;
import modelo.dao.fornecedor.FornecedorDAO;
import modelo.dao.fornecedor.FornecedorDAOImpl;
import modelo.dao.funcionario.FuncionarioDAO;
import modelo.dao.funcionario.FuncionarioDAOImpl;
import modelo.dao.item.ItemDAO;
import modelo.dao.item.ItemDAOImpl;
import modelo.dao.localidade.LocalidadeDAO;
import modelo.dao.localidade.LocalidadeDAOImpl;
import modelo.dao.pedido.PedidoDAO;
import modelo.dao.pedido.PedidoDAOImpl;
import modelo.dao.produto.ProdutoDAO;
import modelo.dao.produto.ProdutoDAOImpl;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidades.produtos.Item;
import modelo.entidades.produtos.Pedido;
import modelo.entidades.produtos.Produto;
import modelo.entidades.produtos.Tipo;
import modelo.entitidades.usuarios.Cliente;
import modelo.entitidades.usuarios.Fornecedor;
import modelo.entitidades.usuarios.PessoaFisica;
import modelo.entitidades.usuarios.Usuario;
import modelo.exceptions.InvalidFieldException;

public class Principal {
	public static void main(String[] args)
			throws InvalidFieldException, CountryInvalidException, EmailInvalidException, PhoneNumberInvalidException {

		System.out.println("Hello World");


		///////////////////////////// CADASTRO ENDERECO
		///////////////////////////// LOCALIDADE//////////////////////////////////////

//		EntityManager em = new Enti

//		BUG - N�O � POSSIVEL RECUPERAR UM FORNECEDOR A PARTIR DE UM PRODUTO
//		RESOLVIDO

		boolean resp = true;
		boolean entrar = false;
		int resposta;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
		ItemDAO itemDAO = new ItemDAOImpl();
		ProdutoDAO produtoDAO = new ProdutoDAOImpl();
		LocalidadeDAO localidadeDAO = new LocalidadeDAOImpl();
		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
//		Cliente cliente1 = new Cliente();

		
//		Produto produto10 = new Produto();
//		produto10.setTipoCarne("Bovino");
//		
//		
//		List<Produto>produtosRecuperadosPorCategoria = produtoDAO.recuperarPorCategoria(produto10);
//		
//		for (Produto produto : produtosRecuperadosPorCategoria) {
//			System.out.println(produto.getNome());
//			System.out.println(produto.getId());
//		}
		
		
		
		Scanner leitor = new Scanner(System.in);

		System.out.println("Pressione 1 para entrar(cliente)");
		System.out.println("Pressione 2 para se cadastrar(cliente)");
		System.out.println("Pressione 3 para entrar(fornecedor)");
		System.out.println("Pressione 4 para se cadastrar(fornecedor)");
		System.out.println("Pressione 5 para entrar(adm)");

		int entrada = leitor.nextInt();

		switch (entrada) {
		case 1: {

			System.out.println("Seu id:(No lugar de login/por enquanto)");
			Long login = leitor.nextLong();

			Usuario clienteRecuperado = clienteDAO.recuperarPorId(login);

			System.out.println("Senha:");
			String senha = leitor.next();

			if (senha.equals(clienteRecuperado.getSenha())) {
				entrar = true;

			} else {
				System.out.println("Senha inv�lida");

			}

			break;
		}
		case 2: {

			Cliente cliente1 = new Cliente();


			
			System.out.println("Nome:");
			String nome = leitor.next();

			System.out.println("Sobrenome:");
			String sobrenome = leitor.next();

			System.out.println("CPF:");
			String CPF = leitor.next();

			System.out.println("Novo login:");
			String login = leitor.next();

			System.out.println("Nova senha:");
			String senha = leitor.next();

			cliente1.setNome(nome);
			cliente1.setSobrenome(sobrenome);
			cliente1.setCPF(CPF);
			cliente1.setLogin(login);
			cliente1.setSenha(senha);

			clienteDAO.inserirCliente(cliente1);

			System.out.println("---------------");
			System.out.println("CONTATO");

			while (resp == true) {
				Contato contato1 = new Contato();

				System.out.println("");
				System.out.println("Novo telefone:");
				String telefone = leitor.next();

				System.out.println("Novo email:");
				String email = leitor.next();

				contato1.setEmail(email);
				contato1.setTelefone(telefone);
//			contato1.setUsuario(cliente1);

				contatoDAO.inserirContato(contato1);

				cliente1.adicionarContato(contato1);
				
				cliente1.setNome(nome);
				cliente1.setSobrenome(sobrenome);
				cliente1.setCPF(CPF);
				cliente1.setLogin(login);
				cliente1.setSenha(senha);
				cliente1.setDataCadastro(LocalDate.now());

//			if( cliente1 instanceof PessoaFisica )
//				System.out.println("Deu certo... eu acho");

//				clienteDAO.inserirCliente(cliente1);

				contatoDAO.atualizarContato(contato1);

				System.out.println("Pressione 1 para adicionar um contato");
				System.out.println("Pressione 2 para continuar");
				resposta = leitor.nextInt();

				if (resposta == 1)
					resp = true;
				else
					resp = false;

			}

			System.out.println("Seu id de login � " + cliente1.getId());
			System.out.println("-------------------------------------");

			entrar = true;

			break;
		}

		case 3: {
			Fornecedor fornecedor1 = new Fornecedor();

			System.out.println("Raz�o social:(O Scanner n�o permite mais de uma palavra)");
			String razaoSocial = leitor.next();
			System.out.println("----------------");

			System.out.println("Nome fantasia:");
			String nomeFantasia = leitor.next();

			fornecedor1.setRazaoSocial(razaoSocial);
			fornecedor1.setNomeFantasia(nomeFantasia);

			fornecedorDAO.inserirFornecedor(fornecedor1);

			break;
		}
		case 4: {
			System.out.println("Seu id:(No lugar de login/por enquanto)");
			Long login = leitor.nextLong();

			Usuario fornecedorRecuperado = fornecedorDAO.recuperarPorId(login);

			System.out.println("Senha:");
			String senha = leitor.next();

			if (senha.equals(fornecedorRecuperado.getSenha())) {
				entrar = true;

			} else {
				System.out.println("Senha inv�lida");

			}

			entrar = true;

			break;
		}
		case 5: {
			System.out.println("Seu id:(No lugar de login/por enquanto)");
			Long login = leitor.nextLong();

			Usuario funcionarioRecuperado = funcionarioDAO.recuperarPorId(login);

			System.out.println("Senha:");
			String senha = leitor.next();

			if (senha.equals(funcionarioRecuperado.getSenha())) {
				entrar = true;

			} else {
				System.out.println("Senha inv�lida");

			}

			break;

		}

		default:
			System.out.println("Valor invalido");
			break;
		}

		while (entrar == true) {

			System.out.println("1- cadastrar novo cliente");
			System.out.println("2- cadastrar novo fornecedor");
			System.out.println("3- cadastrar novo produto");
			System.out.println("4- cadastrar novo -----");
			System.out.println("5- cadastrar novo pedido");
			System.out.println("6- cadastrar novo -------");
			System.out.println("7- recuperar cliente por ");

			resposta = leitor.nextInt();

			switch (resposta) {
			case 1: {
				Cliente cliente1 = new Cliente();

				System.out.println("Nome:");
				String nome = leitor.next();

				System.out.println("Sobrenome:");
				String sobrenome = leitor.next();

				System.out.println("CPF:");
				String CPF = leitor.next();

				System.out.println("Novo login:");
				String login = leitor.next();

				System.out.println("Nova senha:");
				String senha = leitor.next();

				System.out.println("---------------");
				System.out.println("CONTATO");

				while (resp == true) {
					Contato contato1 = new Contato();

					System.out.println("");
					System.out.println("Novo telefone:");
					String telefone = leitor.next();

					System.out.println("Novo email:");
					String email = leitor.next();

					contato1.setEmail(email);
					contato1.setTelefone(telefone);
//					contato1.setUsuario(cliente1);

					contatoDAO.inserirContato(contato1);

					cliente1.adicionarContato(contato1);
					cliente1.setNome(nome);
					cliente1.setSobrenome(sobrenome);
					cliente1.setCPF(CPF);
					cliente1.setLogin(login);
					cliente1.setSenha(senha);
					cliente1.setDataCadastro(LocalDate.now());

//					if( cliente1 instanceof PessoaFisica )
//						System.out.println("Deu certo... eu acho");

					clienteDAO.inserirCliente(cliente1);

					contatoDAO.atualizarContato(contato1);

					System.out.println("Pressione 1 para adicionar um contato");
					System.out.println("Pressione 2 para continuar");
					resposta = leitor.nextInt();

					if (resposta == 1)
						resp = true;
					else
						resp = false;

				}

				break;
			}
			case 2: {
				Fornecedor fornecedor1 = new Fornecedor();

				System.out.println("Raz�o social:(O Scanner n�o permite mais de uma palavra)");
				String razaoSocial = leitor.next();
				System.out.println("----------------");

				System.out.println("Nome fantasia:");
				String nomeFantasia = leitor.next();

				fornecedor1.setRazaoSocial(razaoSocial);
				fornecedor1.setNomeFantasia(nomeFantasia);

				fornecedorDAO.inserirFornecedor(fornecedor1);
			}

				break;

			case 3: {

				Produto produto1 = new Produto();

				System.out.println("Nome:");
				produto1.setNome(leitor.next());

				System.out.println("Id do Fornecedor:");
				Long r = leitor.nextLong();
				Fornecedor fornecedorRecuperado = fornecedorDAO.recuperarPorId(r);

//			produto1.setFornecedor(fornecedorRecuperado);
				produtoDAO.inserirProduto(produto1);

				fornecedorRecuperado.adicionarProduto(produto1);

				fornecedorDAO.atualizarFornecedor(fornecedorRecuperado);

//			fornecedorRecuperado.getProdutos().add(produto1);
//			fornecedorDAO.atualizarFornecedor(fornecedorRecuperado);

//			
				System.out.println("Pre�o compra:");
				produto1.setPrecoCusto(leitor.nextFloat());

				System.out.println("Pre�o venda: ");
				produto1.setPrecoVenda(leitor.nextFloat());

				produtoDAO.atualizarProduto(produto1);

//			fornecedorRecuperado = fornecedorDAO.recuperarPorId(r);

				System.out.println(fornecedorRecuperado.getNomeFantasia());

			}
				break;

			case 5: {

				PedidoDAO pedidoDAO = new PedidoDAOImpl();
				Pedido pedido1 = new Pedido();

				List<Produto> produtos = produtoDAO.recuperarProdutos();

				for (Produto produto : produtos) {
					System.out.println("------------------------------");
					System.out.println(produto.getNome());
					System.out.println(produto.getDescricao());
					System.out.println(produto.getPrecoVenda());
					System.out.println(produto.getId());
					System.out.println("------------------------------");
				}

				do {
					System.out.println("Id do produto:");
					Produto produtoRecuperado = produtoDAO.recuperarPorId(leitor.nextLong());

					Item item = new Item();
					item.setProduto(produtoRecuperado);

					System.out.println("Quantas unidades de " + produtoRecuperado.getNome() + ": ");
					item.setQuantidade(leitor.nextFloat());

					itemDAO.inserirItem(item);
					pedido1.adicionarItem(item);

					System.out.println("Pressione 1 para adicionar um item ao pedido");
					System.out.println("Pressione 2 para continuar");

					resposta = leitor.nextInt();

//				produtoDAO.recuperarProdutoItem(item); // apenas para testar m�todo
//				itemDAO.recuperarItensPedido(pedido1); // apenas para testar m�todo 

				} while (resposta == 1);

			}

			/* em teste */
			default:
				System.out.println("Valor invalido");
				break;
			}

			System.out.println("Pressione 1 para continuar");
			System.out.println("Pressione 2 para finalizar o programa");
			resposta = leitor.nextInt();

			if (resposta == 1) {
				entrar = true;
			} else {
				entrar = false;
			}

		}
//		add metodo na interface
//		String clienteVolta = clienteDAO.recuperarPorId((long) (1)).getNome();
//
//		System.out.println(clienteVolta);
//
//		
//		Fornecedor fornecedor1 = new Fornecedor("Produzimos o melhor do melhor", "Top Meet do Brasil", "loginBrasa",
//				"Senhabemforte", "123.356.411-42");

//				String nome = "Jonas";
//				String sobrenome = "Abelardo";
//				String login = "JoAbLog";
//				String senha = "senhasecreta";
//				String CPF = "121.234.377-32";
//		
//				cliente1.setNome(nome);
//				cliente1.setCPF(CPF);
//				cliente1.setLogin(login);
//				cliente1.setSenha(senha);
//				cliente1.setSobrenome(sobrenome);
////				cliente1.getLocalidades().add(localidade1);
////				cliente1.getLocalidades().add(localidade2);
////				cliente1.setId((long) 1);
//				clienteDAO.inserirCliente(cliente1);
//		
//		List<Localidade>localidades = localidadeDAO.recuperarLocalidadesUsuario(cliente1);
//		localidadeDAO.recuperarLocalidades();
//		
//		for(Usuario usuario: usuarios) {
//		
//			System.out.println(usuario.getLogin());
//			System.out.println(usuario.getId());

//			List<Localidade>localidades = usuario.getLocalidades();
//			
//			for (Localidade localidade : localidades) {
//				System.out.println(localidade.getContinente());
//				System.out.println(localidade.getEstado());
//				System.out.println(localidade.getProvincia());
//				
//			}

//		}

		//
//		Localidade localidade1 = new Localidade("Brasil", "Santa Catarina", "Blumenau", "America do Sul");
//		Localidade localidade2 = new Localidade("Brasil", "S�o Paulo", "Santana de Parna�ba", "America do Sul");
//		localidade1.setId((long) 1);
//		localidadeDAO.inserirLocalidade(localidade1);
//		localidadeDAO.inserirLocalidade(localidade2);
//
//		Endereco endereco1 = new Endereco("Rua sete de setembro", "Pra�a", (short) (242), "414412341", "Apartamento");
//		Endereco endereco2 = new Endereco("Rua xv de setembro", "ogradouro2", (short) (32), "23231211", "Apartamento");
//
//		endereco1.setLocalidade(localidade1);
//		endereco2.setLocalidade(localidade1);
//
//		enderecoDAO.inserirEndereco(endereco1);
//		enderecoDAO.inserirEndereco(endereco2);

//		ClienteDAO clienteDAO = new ClienteDAOImpl();
//
//		Cliente cliente4 = new Cliente();
//
//		cliente1.setId((long)(1));
//		
//		List<Contato> contatos = contatoDAO.recuperarContatosUsuario(cliente1);

//		usuarioDAO.recuperarUsuario;

//		System.out.println(cliente1.getNome());
//		for ( Contato contato : contatos) {
//			System.out.println(contato.getEmail());
//			System.out.println(contato.getTelefone());
//		}

//		 nome = "Luana";
//		sobrenome = "Silva";
//		login = "JoAbLog";
//		senha = "senhasecreta";
//		CPF = "121.234.377-32";
//
//		cliente4.setNome(nome);
//		cliente4.setCPF(CPF);
//		cliente4.setLogin(login);
//		cliente4.setSenha(senha);
//		cliente4.setSobrenome(sobrenome);
//		cliente4.getLocalidades().add(localidade1);
//		cliente4.getLocalidades().add(localidade2);
////		cliente1.setId((long) 1);
//		clienteDAO.inserirCliente(cliente4);
//
//		Cliente cliente2 = new Cliente();
//
//		nome = "Gustavo";
//		sobrenome = "Junkes";
//		login = "JunksLog";
//		senha = "senhasecreta";
//		CPF = "152.346.539-51";
//
//		cliente2.setNome(nome);
//		cliente2.setCPF(CPF);
//		cliente2.setLogin(login);
//		cliente2.setSenha(senha);
//		cliente2.setSobrenome(sobrenome);
//		cliente2.getLocalidades().add(localidade1);
//		cliente2.getLocalidades().add(localidade2);
////		cliente2.setId((long) 1);
//		clienteDAO.inserirCliente(cliente2);
////
//		localidade1.getUsuarios().add(cliente1);
//		localidade1.getUsuarios().add(cliente2);
//		localidade2.getUsuarios().add(cliente1);
//		localidade2.getUsuarios().add(cliente2);
//
//		localidadeDAO.atualizarLocalidade(localidade1);
//		localidadeDAO.atualizarLocalidade(localidade2);
//
//		
//		List<Localidade>localidades = localidadeDAO.recuperarLocalidadesUsuario(cliente1);
//		
//		for (Localidade localidade : localidades) {
//			
//			System.out.println(localidade.getPais());
//			System.out.println(localidade.getEstado());
//			System.out.println(localidade.getProvincia());
//			
//			
//			
//			
//		}
//		
//		ContatoDAO contatoDAO = new ContatoDAOImpl();
//		Contato contato1= new Contato("Junkes@email.com", "1341-4234");
//		Contato contato2= new Contato("Secundario@email.com", "9934-9551");
//		
//		contato1.setUsuario(cliente1);
//		contato2.setUsuario(cliente1);
//
//		contatoDAO.inserirContato(contato1);
//		contatoDAO.inserirContato(contato2);
//		
//		cliente1.getContatos().add(contato1);
//		cliente1.getContatos().add(contato2);
//		
//		clienteDAO.atualizarCliente(cliente1);
		////////////////////////////// CADASTRO PRODUTO
		////////////////////////////// FORNRCEDOR////////////////////////////////

//		FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
//		ProdutoDAO produtoDAO = new ProdutoDAOImpl();
//
//		Fornecedor fornecedor1 = new Fornecedor("Produzimos o melhor do melhor", "Top Meet do Brasil", "loginBrasa",
//				"Senhabemforte", "123.356.411-42");
//		Produto produto3 = new Produto("Lombo", "Este produto � muito gostoso, compre ele", Tipo.BOVINO, 15, 28,
//				new Fornecedor("Saude � nosso lema", "GreenHealth International", "LoginNovo", "13362pp",
//						"321.254.724-54"));
//
//		Fornecedor fornecedor3 = new Fornecedor();
//		Produto produto4 = new Produto();
//
//		produto4.setNome("Calabresa");
//		produto4.setDescricao("Coisa boa");
//		produto4.setPrecoCusto(12);
//		produto4.setPrecoVenda(25);
//		fornecedor3.setNomeFantasia("Carne nova");
//
//		produtoDAO.inserirProduto(produto4);
//		
//		fornecedor3.adicionarProduto(produto4);
//		
//		fornecedorDAO.inserirFornecedor(fornecedor3);
//		
//		produtoDAO.atualizarProduto(produto4);
//		
		//////////////////////////////////////////
//		produtoDAO.inserirProduto(produto4);
//
//		fornecedorDAO.inserirFornecedor(fornecedor3);
//
//		produto4.setFornecedor(fornecedor3);
//
//		produtoDAO.atualizarProduto(produto4);
//
//		fornecedor3.getProdutos().add(produto4);
//
//		fornecedorDAO.atualizarFornecedor(fornecedor3);

		//////////////////// CADASTRO CLIENTE PEDIDO//////////////////////////

//		ClienteDAO clienteDAO = new ClienteDAOImpl();
//		Cliente cliente1 = new Cliente();

//		
//		System.out.println("Nome:");
//		produto1.setNome(leitor.next());
////		
//		System.out.println("Pre�o compra:");
//		produto1.setPrecoCusto(leitor.nextFloat());
//		
//		System.out.println("Pre�o venda: ");
//		produto1.setPrecoVenda(leitor.nextFloat());
//
//		produtoDAO.inserirProduto(produto1);
//		///////////////////////////////////

//		
//		PedidoDAO pedidoDAO = new PedidoDAOImpl();
//		ItemDAO itemDAO = new ItemDAOImpl();
//		Item item1 = new Item();
//		Item item2 = new Item();
//		Item item3 = new Item();
//
//		Produto produto1 = new Produto();
//		Produto produto2 = new Produto();
//
//		Pedido pedido1 = new Pedido();
//
//		produto1.setNome("Maminha");
//		produto2.setNome("Costela");
//
//		produtoDAO.inserirProduto(produto1);
//		produtoDAO.inserirProduto(produto2);
//		
//		String nome = "Jonas";
//		String sobrenome = "Abelardo";
//		String login = "JoAbLog";
//		String senha = "senhasecreta";
//		String CPF = "121.234.377-32";
//
//		cliente1.setNome(nome);
//		cliente1.setCPF(CPF);
//		cliente1.setLogin(login);
//		cliente1.setSenha(senha);
//		cliente1.setSobrenome(sobrenome); //
////		cliente1.setId((long) 1);
//		clienteDAO.inserirCliente(cliente1);
//
//		item1.setProduto(produto1);
//		item1.setQuantidade(10);
//		item1.setValorTotal(item1.calculaValorTotal());
//
//		item2.setProduto(produto2);
//		item2.setQuantidade(10);
//		item2.setValorTotal(item2.calculaValorTotal());
//
//		item3.setProduto(produto2);
//		item3.setQuantidade(10);
//		item3.setValorTotal(item2.calculaValorTotal());
//
//		itemDAO.inserirItem(item1);
//		itemDAO.inserirItem(item2);
//		itemDAO.inserirItem(item3);
//
//		pedido1.adicionarItem(item1);
//		;
//		pedido1.adicionarItem(item2);
//		pedido1.adicionarItem(item3);
//
//		pedido1.setCliente(cliente1);
//
//		pedidoDAO.inserirPedido(pedido1);
//
//		cliente1.getPedidos().add(pedido1);
////		cliente1.setId((long) 14);
//		clienteDAO.atualizarCliente(cliente1);
//
//		List<Pedido> pedidos = pedidoDAO.recuperarPedidosCliente(cliente1);
//
//		for (Pedido pedido : pedidos) {
//			System.out.println(pedido.getId());
//			System.out.println(pedido.getValorTotal());
////			System.out.println(pedido.getItens());
//			System.out.println(pedido.toString());
//
//		}

		//////////////////// CADASTRO CLIENTE///////////////////////////
		/*
		 * ClienteDAO clienteDAO = new ClienteDAOImpl(); Cliente cliente = new
		 * Cliente(); String nome = "Jonas"; String sobrenome = "Abelardo"; String login
		 * = "JoAbLog"; String senha = "senhasecreta"; String CPF = "121.234.377-32";
		 * 
		 * cliente.setNome(nome); cliente.setCPF(CPF); cliente.setLogin(login);
		 * cliente.setSenha(senha); cliente.setSobrenome(sobrenome); //
		 * cliente.setId((long) 1);
		 * 
		 * clienteDAO.inserirCliente(cliente);
		 * 
		 * List<Cliente> clientes = clienteDAO.recuperarClientes();
		 * 
		 * for (int i = 0; i < clientes.size(); i++) { System.out.println("Cliente: " +
		 * clientes.get(i).getNome()); System.out.println("ID:" +
		 * clientes.get(i).getId()); System.out.println(" ");
		 * 
		 * }
		 * 
		 * // clienteDAO.atualizarCliente(cliente);
		 * 
		 * //////////////////// CADASTRO FORNECEDOR///////////////////////////
		 * 
		 * FornecedorDAO fornecedorDAO = new FornecedorDAOImpl(); Fornecedor fornecedor
		 * = new Fornecedor();
		 * 
		 * String nomeFantasia = "Tog Carniefero"; String razaoSocial =
		 * "Mas di cinquentia anius siervino tu familia"; String cnpj =
		 * "176.767.456.354";
		 * 
		 * fornecedor.setNomeFantasia(nomeFantasia);
		 * fornecedor.setRazaoSocial(razaoSocial); fornecedor.setCNPJ(cnpj);
		 * 
		 * fornecedorDAO.inserirFornecedor(fornecedor);
		 * 
		 * //////////////////// CADASTRO FUNCIONARIO///////////////////////////
		 * 
		 * FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
		 * 
		 * Funcionario funcionario = new Funcionario("MeuLogin04",
		 * "MinhaSenhaSecretaMesmo", "J�lia", "Menegildo", "123.134.521-98",
		 * "Estagiario", "Adicionar Produtos");
		 * 
		 * funcionarioDAO.inserirFuncionario(funcionario);
		 * 
		 * //////////////////// CADASTRO PRODUTO///////////////////////////
		 * 
		 * ProdutoDAO produtoDAO = new ProdutoDAOImpl();
		 * 
		 * Produto produto1 = new Produto("Lombo",
		 * "Este produto � muito gostoso, compre ele", Tipo.BOVINO, 15, 28, fornecedor);
		 * 
		 * Produto produto2 = new Produto("peito de frango",
		 * "Carne saud�vel e de qualidade", Tipo.AVE, 10, 18, fornecedor);
		 * 
		 * List<Produto> produtos = new ArrayList<Produto>(); produtos.add(produto1);
		 * produtos.add(produto2);
		 * 
		 * Fornecedor fornecedor1 = new Fornecedor("Produzimos o melhor do melhor",
		 * "Top Meet do Brasil", "loginBrasa", "Senhabemforte", "123.356.411-42");
		 * 
		 * produtoDAO.inserirProduto(produto1); produtoDAO.inserirProduto(produto2);
		 * fornecedorDAO.inserirFornecedor(fornecedor1);
		 * 
		 * 
		 * 
		 * // fornecedorDAO.atualizarFornecedor(fornecedor);
		 * 
		 * produtoDAO.atualizarProduto(produto1);
		 * 
		 * ItemDAO itemDAO = new ItemDAOImpl(); Item item1 = new Item(produto2, 10);
		 * Item item2 = new Item(produto1, 5);
		 * 
		 * itemDAO.inserirItem(item1); itemDAO.inserirItem(item2);
		 * 
		 * PedidoDAO pedidoDAO = new PedidoDAOImpl(); List<Item> itens = new
		 * ArrayList<Item>(); itens.add(item1); itens.add(item2);
		 * 
		 * Pedido pedido = new Pedido(cliente, itens);
		 * 
		 * pedidoDAO.inserirPedido(pedido);
		 */
//		clienteDAO.recuperarClientes();

//		Endereco endereco1 = new Endereco("Rua", "Rua Primeiro de Janeiro", "logradouro", 18, 93234123, "Casa");
//
//		Localidade localidade1 = new Localidade("Estados Unidos", "Florida", "Talahasse", "America do Norte",
//				endereco1);
//
//		
//		
//		Produto produto1 = new Produto("Picanha", "Este produto � muito gostoso, compre ele", Tipo.BOVINO, 22);
//		Produto produto2 = new Produto("Peito de Frango", "Este produto � muito gostoso, compre ele", Tipo.AVE, 16);
//		Produto produto3 = new Produto("Costeleta", "Este produto � muito gostoso, compre ele", Tipo.OVINO, 30);
//		
//		
//			
////		
//		Contato contato4 = new Contato("emailzinho4@gmail.com", "2435-4242");
////
//		System.out.println(contato4.getTelefone());
//		Fornecedor fornecedor1 = new Fornecedor("Ecomeat", "Somos uma empresa fundamentada e vendemos carne", localidade1,
//				 "MeuLogin1", "MinhaSenhaSecreta", contato4, "111.222.333.21");
////		
//		System.out.println(fornecedor1.getCNPJ());
//		System.out.println(fornecedor1.getLogin());
//		System.out.println(fornecedor1.getSenha());
//		System.out.println(fornecedor1.getNomeFantasia());

//

	}

}
