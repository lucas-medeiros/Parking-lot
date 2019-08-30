import java.util.Scanner;

public class Principal {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
		int x = -1;//contador para armazenar a resposta do menu
		do{//menu de selecao
			System.out.println(" ---Menu---");
			System.out.println("0 - sair");
			System.out.println("1 - cadastrar marcas de carro");
			System.out.println("2 - cadastar modelos de carro");
			System.out.println("3 - cadastrar entrada de um carro");
			System.out.println("4 - retirar um carro");
			System.out.println("5 - listar todos os carros estacionados");
			System.out.print("Informe a opcao desejada: ");
			x = teclado.nextInt();
			teclado.nextLine();
			System.out.println();
			switch(x){
			case 0:
				System.out.println("\nAte a proxima! \n");
				break;
			case 1:
				estacionamento.AddMarca();
				break;
			case 2:
				estacionamento.AddModelo();
				break;
			case 3:
				estacionamento.AddCarro();
				break;
			case 4:
				estacionamento.RetiraCarro();
				break;
			case 5:
				estacionamento.ListarCarros();
				break;
			default:
				System.out.println("Numero invalido, por favor insira outro");
				break;
			}
		}while(x != 0);
	}
}