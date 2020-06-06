package dao;

import java.util.List;

import entidade.Funcionario;
import entidade.Telefone;

public interface FuncionarioDAO {
	
	public void inserir(Funcionario funcionario);
	
	public void alterar(Funcionario funcionario);

	public void remover(Funcionario funcionario);

	public Funcionario pesquisar(String matricula);

	public List<Funcionario> listarTodos();
	
	public void removerTelefone(Telefone telefone);
	
	public Telefone pesquisarTelefone(Long id);
	
	public List<Funcionario> pesquisarFuncionario(Funcionario funcionario);

}
