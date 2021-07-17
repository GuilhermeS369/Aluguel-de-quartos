package application;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		method1();
		
	}
	
	public static void method1 () {
		System.out.println("***START METHOD 1***");
		method2();
		System.out.println("***END METHOD 1***");
		
	}
	
	public static void method2 () {
		System.out.println("***START METHOD 2***");
		
		Scanner sc = new Scanner(System.in);
		
		try {
		
		String[] vect = sc.nextLine().split(" ");
		//CRIEI UM VETOR QUE VAI LER CADA PALAVRA APÓS UM ESPAÇO EM BRANCO
		int position = sc.nextInt();
		System.out.println(vect[position]);
		//O VETOR VAI EXIBIR OQ TEM NAQUELA POSITION Q DEFINI COM O NEXT INT
		}
		
		catch(InputMismatchException e) { // AQUI É CASO O PROGRAMA DE O ERRO DE INSERIR
										// UMA LETRA EM VEZ DE UM NUMERO, ELE DA ESSE ERRO
			
		System.out.println("Invalid Caracter");
		}
		
		catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("Invalid Position");
		
		e.printStackTrace(); //APRESENTA O RELATORIO DE ERRO E RASTREIA AS CLASSES ENVOLVIDAS
		}
		System.out.println("***END METHOD 2***");
		
		
		
		sc.close();
				
	}

}
