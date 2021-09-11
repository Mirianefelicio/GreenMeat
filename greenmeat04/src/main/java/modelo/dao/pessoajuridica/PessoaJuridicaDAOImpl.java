package modelo.dao.pessoajuridica;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import modelo.entitidades.usuarios.PessoaJuridica;

public class PessoaJuridicaDAOImpl implements PessoaJuridicaDAO {

	public void inserirPessoaJuridica(PessoaJuridica pessoaJuridica) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(pessoaJuridica);
			
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
	
	
	
	

	public void deletarPessoaJuridica(PessoaJuridica pessoaJuridica) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(pessoaJuridica);

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
	
	
	public void atualizarPessoaJuridica(PessoaJuridica pessoaJuridica) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(pessoaJuridica);

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
	
	

	public List<PessoaJuridica> recuperarPessoasJuridicas() {

		Session sessao = null;
		List<PessoaJuridica> pessoasJuridicas = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PessoaJuridica> criteria = construtor.createQuery(PessoaJuridica.class);
			Root<PessoaJuridica> raizPessoaJuridica = criteria.from(PessoaJuridica.class);

			criteria.select(raizPessoaJuridica);

			pessoasJuridicas = sessao.createQuery(criteria).getResultList();

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

		return pessoasJuridicas;

	}
	
	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.Cliente.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.Usuario.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.PessoaFisica.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.Fornecedor.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.Funcionario.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.PessoaJuridica.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.information.Contato.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.information.Endereco.class);
		configuracao.addAnnotatedClass(modelo.entitidades.usuarios.information.Localidade.class);
		configuracao.addAnnotatedClass(modelo.entidades.produtos.Estoque.class);
		configuracao.addAnnotatedClass(modelo.entidades.produtos.Item.class);
		configuracao.addAnnotatedClass(modelo.entidades.produtos.Pedido.class);
		configuracao.addAnnotatedClass(modelo.entidades.produtos.Produto.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
				.build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;

	}
}
