package model.dao.produto;

import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.entities.products.Item;
import model.entities.products.Pedido;
import model.entities.products.Produto;
import model.entities.products.Tipo;
import model.entities.users.Cliente;

public class ProdutoDAOImpl implements ProdutoDAO {

	public void inserirProduto(Produto produto) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(produto);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

	}

	public void deletarProduto(Produto produto) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(produto);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

	}

	public void atualizarProduto(Produto produto) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(produto);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public Produto recuperarPorId(Long id) {
		Session sessao = null;
		Produto produto = null;
		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			produto = sessao.find(Produto.class, id);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return produto;

	}

	public Produto recuperarProdutoItem(Item item) {

		Session sessao = null;
		Produto produto = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Produto> criteria = construtor.createQuery(Produto.class);
			Root<Produto> raizProduto = criteria.from(Produto.class);

			Join<Produto, Item> juncaoItem = raizProduto.join("produto");

			ParameterExpression<Long> idItem = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoItem.get("id"), idItem));

			produto = sessao.createQuery(criteria).setParameter(idItem, item.getId()).getSingleResult();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return produto;
	}

	public List<Produto> recuperarProdutos() {

		Session sessao = null;
		List<Produto> produtos = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Produto> criteria = construtor.createQuery(Produto.class);
			Root<Produto> raizProduto = criteria.from(Produto.class);

			criteria.select(raizProduto);

			produtos = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return produtos;

	}
	
	
	
	public List<Produto>recuperarPorCategoria(String categoria){
		Session sessao = null;
		List<Produto> produtos = null;
		
		
		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Produto> criteria = construtor.createQuery(Produto.class);
			Root<Produto> raizProduto = criteria.from(Produto.class);

//			Join<Produto, Item> juncaoItem= raizProduto.join("produto");

			ParameterExpression<String> categoriaProduto = construtor.parameter(String.class);
			criteria.where(construtor.equal(categoriaProduto, categoria));

			produtos = sessao.createQuery(criteria).setParameter(categoriaProduto, categoria ).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		
		
		return produtos;
	}
	
	
	

	public List<Produto> recuperarPorCategoria(Produto produto) {

		Session sessao = null;
		List<Produto> produtos = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Produto> criteria = construtor.createQuery(Produto.class);
			Root<Produto> raizProduto = criteria.from(Produto.class);

			criteria.select(raizProduto);

			ParameterExpression<String> categoriaProduto = construtor.parameter(String.class);
			criteria.where(construtor.equal(raizProduto.get("tipoCarne"), categoriaProduto));

			produtos = sessao.createQuery(criteria).setParameter(categoriaProduto, produto.getTipoCarne())
					.getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		return produtos;
	}

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(model.entities.users.Cliente.class);
		configuracao.addAnnotatedClass(model.entities.users.Usuario.class);
		configuracao.addAnnotatedClass(model.entities.users.PessoaFisica.class);
		configuracao.addAnnotatedClass(model.entities.users.Fornecedor.class);
		configuracao.addAnnotatedClass(model.entities.users.Funcionario.class);
		configuracao.addAnnotatedClass(model.entities.users.PessoaJuridica.class);
		configuracao.addAnnotatedClass(model.entities.users.information.Contato.class);
		configuracao.addAnnotatedClass(model.entities.users.information.Endereco.class);
		configuracao.addAnnotatedClass(model.entities.users.information.Localidade.class);
		configuracao.addAnnotatedClass(model.entities.products.Estoque.class);
		configuracao.addAnnotatedClass(model.entities.products.Item.class);
		configuracao.addAnnotatedClass(model.entities.products.Pedido.class);
		configuracao.addAnnotatedClass(model.entities.products.Produto.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
				.build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;

	}

}
