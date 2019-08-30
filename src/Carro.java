public class Carro {
	
	private String placa;
	private String marca;
	private String modelo;
	private int horaEntrada;
	private int minutoEntrada;
	private int vaga;
	
	public Carro(String placa, String marca, String modelo, int horaEntrada, int minutoEntrada, int vaga) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.horaEntrada = horaEntrada;
		this.minutoEntrada = minutoEntrada;
		this.vaga = vaga;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public int getMinutoEntrada() {
		return minutoEntrada;
	}

	public void setMinutoEntrada(int minutoEntrada) {
		this.minutoEntrada = minutoEntrada;
	}

	public int getVaga() {
		return vaga;
	}

	public void setVaga(int vaga) {
		this.vaga = vaga;
	}
	
	public String toString(){
		return "Carro de placa: " + this.placa + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + 
				"\nEntrou as: " + this.horaEntrada + ":" + this.minutoEntrada + "\nOcupadando a vaga: " + this.vaga;
	}
		
}