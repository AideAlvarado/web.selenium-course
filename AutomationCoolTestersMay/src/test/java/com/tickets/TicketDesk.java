package com.tickets;

public class TicketDesk {

	public static void main(String[] args) { //aqui en el Main es dnd va a correr mi programa. Seria como la taquilla del parque. Y cuando se ejecute el programa va a tener que pasar por la clase abstracta.
		
		//Inputs
		double price = 100;
		boolean isStudent = true;
		int age = 20;
		
		
		//aqui es donde vamos a ver el polimorfismo y vamos a instanciar:
		//nombre le clase Padre / nombre del objeto / new crear nuevo objeto / constructor
		TicketsParks ticket = new CoolParkTicket(price, isStudent, age);
		ticket.printPriceDay();
		double coolprice = ticket.getTicketPrice();
		
		//Testers Park
		ticket = new TestersParkTicket(price, isStudent, age);
		ticket.printPriceDay();
		double testersprice = ticket.getTicketPrice();
		
		//TAREA:
		//si es niño y estudiante, que me de otro precio
		//utilizar el metodo printPriceDay con la key como parametro
		//Agregar un constructor a la clase testersParkTicket, que tenga un descuento especial (sobre cargar el contructor TesterParkTicket y que tenga un descuento especial para todos los tickets.
		//Generar un metodo static en TicketDesk que sume el total de los tickets que se vayan a comprar e imprima el precio total
		

	}

}
