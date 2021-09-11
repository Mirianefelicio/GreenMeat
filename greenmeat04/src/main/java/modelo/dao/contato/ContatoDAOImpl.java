package modelo.dao.contato;

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

import modelo.entitidades.usuarios.Usuario;
import modelo.entitidades.usuarios.information.Contato;
import modelo.entitidades.usuarios.information.Localidade;

public class ContatoDAOImpl implements ContatoDAO {

	public void inserirContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(contato);

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

	public void deletarContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(contato);

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

	public void atualizarContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(contato);

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

	public List<Contato> recuperarContatos() {

		Session sessao = null;
		List<Contato> contatos = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizContato = criteria.from(Contato.class);

			criteria.select(raizContato);

			contatos = sessao.createQuery(criteria).getResultList();

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

		return contatos;

	}

	public List<Contato> recuperarContatosUsuario(Usuario usuario) {

		Session sessao = null;
		List<Contato> contatos= null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizContato = criteria.from(Contato.class);

			Join<Contato, Usuario> juncaoUsuario = raizContato.join("usuario");

			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoUsuario.get("id"), idUsuario));

			contatos = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getResultList();

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

		return contatos;
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
