package modelo.dao.localidade;

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
import modelo.entitidades.usuarios.information.Endereco;
import modelo.entitidades.usuarios.information.Localidade;

public class LocalidadeDAOImpl implements LocalidadeDAO {

	
	
	public void inserirLocalidade(Localidade localidade) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(localidade);

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

	public void deletarLocalidade(Localidade localidade) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(localidade);

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

	public void atualizarLocalidade(Localidade localidade) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(localidade);

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
	
	public Localidade recuperarLocalidadeEndereco(Endereco endereco) {

		Session sessao = null;
		Localidade localidade = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Localidade> criteria = construtor.createQuery(Localidade.class);
			Root<Localidade> raizLocalidade = criteria.from(Localidade.class);

			Join<Localidade, Endereco> juncaoEndereco = raizLocalidade.join("enderecos");

			ParameterExpression<Long> idEndereco = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoEndereco.get("id"), idEndereco));

			localidade = sessao.createQuery(criteria).setParameter(idEndereco, endereco.getId()).getSingleResult();

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

		return localidade;
	}

			

	public List<Localidade> recuperarLocalidades() {

		Session sessao = null;
		List<Localidade> localidades = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Localidade> criteria = construtor.createQuery(Localidade.class);
			Root<Localidade> raizLocalidade = criteria.from(Localidade.class);

			criteria.select(raizLocalidade);

			localidades = sessao.createQuery(criteria).getResultList();

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

		return localidades;
	}

	public List<Localidade> recuperarLocalidadesUsuario(Usuario usuario) {

		Session sessao = null;
		List<Localidade> localidades = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Localidade> criteria = construtor.createQuery(Localidade.class);
			Root<Localidade> raizLocalidade = criteria.from(Localidade.class);

			Join<Localidade, Usuario> juncaoUsuario = raizLocalidade.join("usuarios");

			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoUsuario.get("id"), idUsuario));

			localidades = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getResultList();

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

		return localidades;
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
