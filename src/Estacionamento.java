import java.util.ArrayList;
import java.util.Scanner;

public class Estacionamento {
	
	static Scanner teclado = new Scanner(System.in);
	private static Carro[] estacionamento;
	private static ArrayList<String> alMarca = new ArrayList<String>();//guarda as marcas cadastradas
	private static ArrayList<String> alModelo = new ArrayList<String>();//guarda os modelos cadastrados
	
	public Estacionamento(){
		estacionamento = new Carro[100];//cria o vetor de carros com 100 lugares (estacionamento)
		this.EsvaziaEstacionamento();//marca todos os lugares como vazios
	}
	
	public void EsvaziaEstacionamento(){
		for (int i = 0; i < estacionamento.length; i++) {
			estacionamento[i] = null;//marca todos os lugares como null (vazios)
		}
	}
	
	public void AddMarca(){
		String marca = "";
		while (marca.isEmpty()){
			System.out.println("Insira a marca que deseja adicionar: ");
			marca = teclado.nextLine();
			if (marca.isEmpty()){
				System.out.println("Marca invalida, por favor insira outra");
			}
		}
		alMarca.add(marca);//adiciona a marca insirida pelo usuario ao array list de marcas
		System.out.println("Marca adionada com sucesso");
	}
	
	public void AddModelo(){
		String modelo = "";
		while (modelo.isEmpty()){
			System.out.println("Insira o modelo que deseja adicionar: ");
			modelo = teclado.nextLine();
			if (modelo.isEmpty()){
				System.out.println("Modelo invalido, por favor insira outra");
			}
		}
		alModelo.add(modelo);//adiciona a marca insirida pelo usuario ao array list de modelos
		System.out.println("Modelo adionado com sucesso");
	}
	
	public int ImprimeMarcas(){
		if (alMarca.isEmpty()){
			System.out.println("Nenhuma marca foi cadastrada ainda");
			return -1;//sai da funcao retornando -1 depois de imprimir a mensagem de erro
		}
		for (int i = 0; i < alMarca.size(); i++) {
			System.out.println(i + " - " +  alMarca.get(i));
		}
		return 0;
	}
	
	public int ImprimeModelos(){
		if (alModelo.isEmpty()){
			System.out.println("Nenhum modelo foi cadastrado ainda");
			return -1;//sai da funcao retornando -1 depois de imprimir a mensagem de erro
		}
		for (int i = 0; i < alModelo.size(); i++) {
			System.out.println(i + " - " +  alModelo.get(i));
		}
		return 0;
	}
	
	public void AddCarro(){
		int retorno = 0, marca = -1, modelo = -1, horaentrada = -1, minutoentrada = -1, vaga;
		String placa = "";
		System.out.println("Insira a placa do seu carro: ");
		while(placa.isEmpty()){
			placa = teclado.nextLine();
			if(placa.isEmpty()){
				System.out.println("Placa invalida, por favor insira outra");
			}
		}
		System.out.println("Insira a marca do seu carro: ");
		retorno = this.ImprimeMarcas();
		while (marca < 0){
			if (retorno == -1){
				marca = 0;
			}
			marca = teclado.nextInt();
			teclado.nextLine();
			if ((marca < 0) || (marca > alMarca.size())){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		System.out.println("Insira o modelo do seu carro: ");
		retorno = this.ImprimeModelos();
		while (modelo < 0){
			if (retorno == -1){
				modelo = 0;
			}
			modelo = teclado.nextInt();
			teclado.nextLine();
			if ((modelo < 0) || (modelo > alModelo.size())){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		System.out.println("Insira a hora de entrada do carro no estacionamento: ");
		while((horaentrada < 0) || (horaentrada > 24)){
			horaentrada = teclado.nextInt();
			teclado.nextLine();
			if((horaentrada < 0) || (horaentrada > 24)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		System.out.println("Insira o minuto de entrada do carro no estacionamento: ");
		while((minutoentrada < 0) || (minutoentrada > 60)){
			minutoentrada = teclado.nextInt();
			teclado.nextLine();
			if((minutoentrada < 0) || (minutoentrada > 60)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		do{
			System.out.println("Insira a vaga na qual deseja estacionar (0..99)");
			vaga = teclado.nextInt();
			teclado.nextLine();
			if((vaga < 0) || (vaga > 99) || (estacionamento[vaga] != null)){
				System.out.println("Essa vaga se encontra ocupada ou é invalida, por favor insira outra");
			}
		}while((vaga < 0) || (vaga > 99) || (estacionamento[vaga] != null));
		Carro c = new Carro(placa, alMarca.get(marca), alModelo.get(modelo), horaentrada, minutoentrada, vaga);
		estacionamento[vaga] = c;
		System.out.println("Carro estacionado com sucesso");
	}
	
	public void RetiraCarro(){
		int vaga = -1, minutoagora = -1, horaagora = -1;
		float preco, tempo;
		System.out.println("Insira a vaga em que seu carro esta estacionado: ");
		do{
			vaga = teclado.nextInt();
			teclado.nextLine();
			if ((vaga < 0) || (vaga > 99) || (estacionamento[vaga] == null)){
				System.out.println("Vaga invalida, por favor insira outra");
			}
		}while((vaga < 0) || (vaga > 99) || (estacionamento[vaga] == null));
		System.out.println("Insira a hora de agora: ");
		while((horaagora < 0) || (horaagora > 24)){
			horaagora = teclado.nextInt();
			teclado.nextLine();
			if((horaagora < 0) || (horaagora > 24)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		System.out.println("Insira o minuto de agora: ");
		while((minutoagora < 0) || (minutoagora > 60)){
			minutoagora = teclado.nextInt();
			teclado.nextLine();
			if((minutoagora < 0) || (minutoagora > 60)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		Carro c = estacionamento[vaga];
		tempo = (((horaagora*60) + minutoagora) - ((c.getHoraEntrada()*60) + c.getMinutoEntrada()));
		if (tempo <= 120){
			preco = (float) 14;
		}else{
			preco = (float) (14 + (((int) (tempo - 120)/15)*2.5));
		}
		estacionamento[vaga] = null;
		System.out.printf("Preco a pagar: R$%.2f\n", preco);
		System.out.println("Tempo de permanencia no estacionamento: " + (int)(tempo/60) + " horas e " 
							+ ((int) ((((float)(tempo/60)) - (int)(tempo/60))*60)+1) + " minutos\n");
	}

	public void ListarCarros(){
		for (int i = 0; i < estacionamento.length; i++) {
			if(estacionamento[i] != null){
				System.out.println(estacionamento[i].toString() + "\n");
			}
		}
	}
	
}