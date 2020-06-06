package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;
import jpaUtil.jpaUtil;




public class UsuarioDAOImpl implements UsuarioDAO {

	public void inserir(Usuario usuario) {
		
		EntityManager ent = jpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(usuario);
		
		tx.commit();
		ent.close();

	}


	public void alterar(Usuario usuario) {

		EntityManager ent = jpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(usuario);
		
		tx.commit();
		ent.close();

	}


	public void remover(Usuario usuario) {
		
		EntityManager ent = jpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(usuario);
		
		tx.commit();
		ent.close();
		
	}

	public Usuario pesquisar(String cpf) {
		
		EntityManager ent = jpaUtil.getEntityManager();
		Usuario usuario = ent.find(Usuario.class, cpf);
		
		return usuario;
		
	}

	public List<Usuario> listarTodos() {

		EntityManager ent = jpaUtil.getEntityManager();

		Query query = ent.createQuery("from Usuario u");
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
	
		return usuarios;
		
	}
	
}
