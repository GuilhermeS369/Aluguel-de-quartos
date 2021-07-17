package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
										//SE O METODO DOMAINEXCEPTION FOR SÓ RUNTIME, PRECISO DO THROWS
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) /*throws DomainException*/{
		
		if (!checkOut.after(checkIn)) {  //LANÇADA JA DE INICIO A VERIFICAÇÃO
			//SE A DATA DE CHECKOUG NAO FOR POSTERIOR A DATA DE CHECKING
			throw new DomainException("Check-out date must be after check-in date");
			//MESMA COISA DO OUTRO
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime(); 
		//getTime - ME ENTREGA A QUANTIDADE DE MILISEGUNDOS DESSA DATA
		//DIFERENÇA ENTRE DATAS EM MILISEGUNDOS
			
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); 
		//RETORNA A CONVERSÃO PARA DIAS, A VARIAVEL DIFF, E OQ TEM NELA SÃO OS MILISEGUNDOS.
		//TIPO ENUMERADO COMPLETO Q TEM ALGUMAS OPERAÇÕES 
	}			
															//SE O METODO DOMAINEXCEPTION FOR SÓ RUNTIME, PRECISO DO THROWS
	public void updateDates (Date checkIn, Date checkOut) /*throws DomainException*/ { 
		//CRIANDO O TRATAMENTO DE ERROS FAZENDO IF
		//COM DIREITO A RETORNO DE MENSAGEM PERSONALIZADA
		//**THROWS** COMO É O PROGRAMA QUE TEM O TRY EO CATCH, E É LA Q VOU TRATAR DO ERRO
		// ENTAO ESSA DAQUI EU SÓ COLOCO O THROWS DOMAIN EXCEPTION, PQ VAI SER TRATADA EM OUTRO LUGAR 
		Date now = new Date(); 
		if (checkIn.before(now) || checkOut.before(now))  {
			//SE A DATA DE AGORA VIER DEPOIS DA DATA DE CHEKING 
			//E A DATA  DE AGORA VIER DEPOIS DA DATA DE CHECKOUT
			throw new DomainException("Reservation dates for update must be future date");
			// QUANDO OS ARGUMENTOS Q PASSAMOS PARA A CLASSE(CHECKIN E CHECKOUT) ESTA ERRADA
			//QUE SERIA O ILLEGAL ARGUMENT, ELE VAI RETORNAR A MENSAGEM
			//OU SEJA, ELE CRIA UM NOVO METODO COM ESSA MENSAGEM
			}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		
		
	}
	
	@Override
	
	public String toString() {
		
		return "Room " 
		+ roomNumber
		+ ", check-in: "
		+ sdf.format(checkIn)
		+ ", check-out: "
		+ sdf.format(checkOut)
		+", "
		+ duration()
		+" nights";
	}
	
}
