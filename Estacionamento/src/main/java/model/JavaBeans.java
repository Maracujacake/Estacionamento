package model;

public class JavaBeans {
	private String idCarro;
	private String idCliente;
	private String placa;
	private String nome;
	private String telefone;
	private String horaChegada;
	private String horaSaida;
	private String idPagamento;
	private String Preco;
	
	
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JavaBeans(String idCarro, String idCliente, String placa, String nome, String telefone, String horaChegada,
			String horaSaida, String idPagamento, String preco) {
		super();
		this.idCarro = idCarro;
		this.idCliente = idCliente;
		this.placa = placa;
		this.nome = nome;
		this.telefone = telefone;
		this.horaChegada = horaChegada;
		this.horaSaida = horaSaida;
		this.idPagamento = idPagamento;
		Preco = preco;
	}


	public String getIdCarro() {
		return idCarro;
	}


	public void setIdCarro(String idCarro) {
		this.idCarro = idCarro;
	}


	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getHoraChegada() {
		return horaChegada;
	}


	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}


	public String getHoraSaida() {
		return horaSaida;
	}


	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}


	public String getIdPagamento() {
		return idPagamento;
	}


	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}


	public String getPreco() {
		return Preco;
	}


	public void setPreco(String preco) {
		Preco = preco;
	}
	
	
	
}
