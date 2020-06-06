package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import entidade.Funcionario;
import entidade.Telefone;
import entidade.Usuario;

@ManagedBean(name = "FuncionarioBean")
@SessionScoped
public class FuncionarioBean {

	private Funcionario funcionario;
	private Telefone TelefoneAdicionar;

	private FuncionarioDAO funcionarioDAO;
	
	private long idTelefoneSelecionado;
	
	private Usuario usuarioLogado;
	
	private List<Funcionario> listaFuncionarios;
	
	
	private String matriculaFuncionarioSelecionado;

	public FuncionarioBean() {
		
		this.funcionario = new Funcionario();
		this.funcionario.setTelefones(new ArrayList<Telefone>());
		
		this.TelefoneAdicionar = new Telefone();
		
		this.funcionarioDAO = new FuncionarioDAOImpl();
		
		this.listaFuncionarios = new ArrayList<Funcionario>();
		
		this.atualizarUsuarioLogado();
	}
	
	public void atualizarUsuarioLogado() {
		HttpSession sessao = (HttpSession)FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}
	
	public void salvarFuncionario() {
		
		if(this.funcionario.getMatricula() == null) {
			this.funcionarioDAO.inserir(this.funcionario);			
		}else {
			this.funcionarioDAO.alterar(this.funcionario);
		}
		//adicionar mensagem de sucesso.
		
	}
	
	public void adicionarTelefone() {
		
		Telefone novoTelefone = new Telefone();
		
		novoTelefone.setDdd(this.TelefoneAdicionar.getDdd());
		novoTelefone.setNumero(this.TelefoneAdicionar.getNumero());
		novoTelefone.setTipo(this.TelefoneAdicionar.getTipo());
		novoTelefone.setFuncionario(this.funcionario);
		
		boolean achou = false;
		for (Telefone Telefone : this.funcionario.getTelefones()) {
			if(Telefone.getId().equals(this.TelefoneAdicionar.getId())) {
				achou = true;
			}
		}
		
		if(achou) {
			//mensagem Telefone j� existe na lista
		}else {
			this.funcionario.getTelefones().add(novoTelefone);			
		}
				
		//adicionar mensagem de sucesso.
		
	}
	
	public void removerTelefone() {
		
		Telefone TelefoneAchado = null;
		
		for (Telefone Telefone : this.funcionario.getTelefones()) {
			if(Telefone.getId().equals(this.idTelefoneSelecionado)) {
				TelefoneAchado = Telefone;
			}
		}
		
		if(TelefoneAchado != null) {
			
			this.funcionario.getTelefones().remove(TelefoneAchado);
			
			if(TelefoneAchado.getId() != null) {
				this.funcionarioDAO.removerTelefone(TelefoneAchado);
			}
		}
	}
	
	public void pesquisarFuncionario() {
//		this.listaFuncionarios = this.funcionarioDAO.listarTodos();
		this.listaFuncionarios = this.funcionarioDAO.pesquisarFuncionario(this.funcionario);
	}
	
	public String editarFuncionario() {
		
		Funcionario FuncionarioRecuperado = this.funcionarioDAO.pesquisar(this.matriculaFuncionarioSelecionado);
		
		if(FuncionarioRecuperado != null) {
			this.funcionario = FuncionarioRecuperado;
			return "manterFuncionario.xhtml";
		}else {
			//Manda erro,n�o achou
			return "";
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Telefone getTelefoneAdicionar() {
		return TelefoneAdicionar;
	}

	public void setTelefoneAdicionar(Telefone telefoneAdicionar) {
		TelefoneAdicionar = telefoneAdicionar;
	}

	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	public long getIdTelefoneSelecionado() {
		return idTelefoneSelecionado;
	}

	public void setIdTelefoneSelecionado(long idTelefoneSelecionado) {
		this.idTelefoneSelecionado = idTelefoneSelecionado;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public String getMatriculaFuncionarioSelecionado() {
		return matriculaFuncionarioSelecionado;
	}

	public void setMatriculaFuncionarioSelecionado(String matriculaFuncionarioSelecionado) {
		this.matriculaFuncionarioSelecionado = matriculaFuncionarioSelecionado;
	}
	

}
