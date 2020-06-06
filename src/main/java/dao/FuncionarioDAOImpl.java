package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Funcionario;
import entidade.Telefone;
import jpaUtil.jpaUtil;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	public void inserir(Funcionario funcionario) {

		EntityManager ent = jpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.persist(funcionario);

		tx.commit();
		ent.close();

	}

	public void alterar(Funcionario funcionario) {

		EntityManager ent = jpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.merge(funcionario);

		tx.commit();
		ent.close();

	}

	public void remover(Funcionario funcionario) {

		EntityManager ent = jpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.remove(funcionario);

		tx.commit();
		ent.close();

	}

	public Funcionario pesquisar(String matricula) {

		EntityManager ent = jpaUtil.getEntityManager();
		Funcionario funcionario = ent.find(Funcionario.class, matricula);

		return funcionario;

	}

	public List<Funcionario> listarTodos() {

		EntityManager ent = jpaUtil.getEntityManager();

		Query query = ent.createQuery("from Funcionario f");

		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios = query.getResultList();

		return funcionarios;

	}

	public void removerTelefone(Telefone telefone) {
		EntityManager ent = jpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		Telefone achou = ent.find(Telefone.class, telefone.getId());

		ent.remove(achou);

		tx.commit();
		ent.close();
	}

	public Telefone pesquisarTelefone(Long id) {

		EntityManager ent = jpaUtil.getEntityManager();
		Telefone telefone = ent.find(Telefone.class, id);

		return telefone;

	}

	public List<Funcionario> pesquisarFuncionario(Funcionario funcionario) {

		EntityManager ent = jpaUtil.getEntityManager();

		Query query = ent
				.createQuery("from Funcionario f where 1=1 " + this.montarWherePesquisaFuncionario(funcionario));

		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios = query.getResultList();

		return funcionarios;
	}

	private String montarWherePesquisaFuncionario(Funcionario funcionario) {

		String where = "";

		// nome
		if (funcionario.getNome() != null && !funcionario.getNome().isEmpty()) {
			where += "and Upper(f.nome) like Upper('%" + funcionario.getNome() + "%')";
		}

		// matricula
		if (funcionario.getMatricula() != null && !funcionario.getMatricula().isEmpty()) {
			where += "and Upper(f.matricula) like Upper('%" + funcionario.getMatricula() + "%')";
		}

		// cargo
		if (funcionario.getCargo() != null && !funcionario.getCargo().isEmpty()) {
			where += "and Upper(f.cargo) like Upper('%" + funcionario.getCargo() + "%')";
		}

		// cidade
		if (funcionario.getCidade() != null && !funcionario.getCidade().isEmpty()) {
			where += "and Upper(f.cidade) like Upper('%" + funcionario.getCidade() + "%')";
		}

		// bairro
		if (funcionario.getBairro() != null && !funcionario.getBairro().isEmpty()) {
			where += "and Upper(f.bairro) like Upper('%" + funcionario.getBairro() + "%')";
		}

		return where;
	}

}
