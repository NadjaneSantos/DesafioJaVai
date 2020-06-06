package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="FUNCIONARIO")
public class Funcionario {
	

	@Id
	@Column(name = "MATRICULA", nullable = false)
	private String matricula;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
		
	@Column(name = "CARGO", nullable = false)
	private String cargo;
	
	@Column(name = "RUA", nullable = false)
	private String rua;
	
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@Column(name = "COMPLEMENTO", nullable = false)
	private String complemento;
	
	@OneToMany(mappedBy = "FUNCIONARIO", cascade = CascadeType.PERSIST)
	private List<Telefone> telefones;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}
