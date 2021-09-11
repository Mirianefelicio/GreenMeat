package modelo.dao.funcionario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import modelo.entitidades.usuarios.Cliente;
import modelo.entitidades.usuarios.Funcionario;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	public void inserirFuncionario(Funcionario funcionario) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(funcionario);

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

	public void deletarFuncionario(Funcionario funcionario) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(funcionario);

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

	public void atualizarFuncionario(Funcionario funcionario) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(funcionario);

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

	
	public Funcionario recuperarPorId(Long id) {
		Session sessao = null;
		Funcionario funcionario = null;
		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			funcionario = sessao.find(Funcionario.class, id );

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
		
		return funcionario;
		
	}
	
	
	
	public List<Funcionario> recuperarFuncionarios() {

		Session sessao = null;
		List<Funcionario> funcionarios = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Funcionario> criteria = construtor.createQuery(Funcionario.class);
			Root<Funcionario> raizFuncionario = criteria.from(Funcionario.class);

			criteria.select(raizFuncionario);

			funcionarios = sessao.createQuery(criteria).getResultList();

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

		return funcionarios;

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
