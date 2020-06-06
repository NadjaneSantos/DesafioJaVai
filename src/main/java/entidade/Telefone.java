package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="TELEFONE")
public class Telefone {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "S_FEIRA")
	@SequenceGenerator(name = "S_FEIRA", sequenceName = "S_FEIRA", allocationSize = 1)
	private Long id;
	
	@Column(name = "DDD", nullable = false)
	private String ddd;
	
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@Column(name = "TIPO", nullable = false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "MATRICULA_FUNCIONARIO", referencedColumnName = "MATRICULA", nullable = false)
	private Funcionario funcionario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
