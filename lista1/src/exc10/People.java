package exc10;

public class People {
	private Long cpf;
	private String nome;
	private String email;
	
	public People(Long cpf, String nome, String email){
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
