package com.tickets;

public abstract class TicketsParks { //clase abstracta por la syntasis "abstract"
	
	//Instancia de variable o instancia de objeto
	String welcomeMessage;
	
	//generamos el constructor que se tiene que llamar igual a la clase:
	
	public TicketsParks() {
		this.welcomeMessage = "Bienvenidos a CoolTesters Parks - "; //el this se refiere a la clase dnd esta posicionado
	}
	
	//metodo para obtener mensaje:
	public String welcomeMessageString() {
		return this.welcomeMessage;
	}
	
	//metodos abstractos:
	public abstract double getTicketPrice();
	public abstract void printPriceDay();
	public abstract void printPriceDay(String authKey, String priceDay);

}
