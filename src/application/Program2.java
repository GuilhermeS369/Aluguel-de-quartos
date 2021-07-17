package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program2 {

	public static void main(String[] args)  { //RETIRAMOS O TROWNS PARA TRATAR NO PROPRIO CODIGO
		
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			 					
			reservation.updateDates(checkIn, checkOut); // FOI TRATADA COM O CATCH
			System.out.println("Reservation: " + reservation);
		}
		
		catch (ParseException e) { //CASO DE ERRO DE POR A DATA DE FORMA ERRADA
			System.out.println("Invalid date format");
		}
		
		catch (DomainException e) { //CLASSE PERSONALIZADA
			//CASO DE O ERRO, ELE VAI RETORNAR O ILLEGAL
			//POIS FIZEMOS COM QUE RETORNE ESSE ERRO LA NA CLASSE
			//VISTO ISSO TEM UMA MENSAGEM DENTRO DA ILLEGAL ARGUMENT QUE AGORA TEM O NOME
			// DE "e"
			System.out.println("Error in reservation: " + e.getMessage());
		//AQUI ELE VAI PRINTAR A MENSAGEM E CHAMAR A MESSAGE QUE COLOQUEI LA NA CLASSE
		}
		catch (RuntimeException e) {//ESSA CATCH PEGA QLQER TIPO DE OUTRO ERRO
			//EAI APRESENTA ESSA MENSAGEM DE ERRO INESPERADO
			System.out.println("Unexpected error");
		}
		
		
		
		sc.close();
		
	}

}
