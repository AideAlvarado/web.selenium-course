package com.tickets;

public class TestersParkTicket extends TicketsParks {

	double adultTicket;
	double childTicket;
	double studentTicket;
	boolean student = false;
	String priceDay;
	String park;
	int age;

	// generamos un constructor:
	public TestersParkTicket(double price, boolean student, int age) {
		// para usar algo de mi clase abstracta, se usa la sentencia super:
		super(); // para traerme sus propiedades del constructor -->TicketsParks()
		this.adultTicket = price;
		this.childTicket = price * (0.85);
		this.studentTicket = price * (0.6);
		this.student = student;
		this.priceDay = "Precio dia regular";
		this.park = "Testers Park";
		this.age = age;
	}

	// Vamos a encapsular:

	private void setPriceDay(String priceDay) { // normalmente es privado.
		// me est� dando un error donde dice que mi metodo no lo estoy usando asi
		// que sobrecargamos abajo.
		this.priceDay = priceDay;
	}

	private String getPriceDay() {
		return priceDay;
	}

	// estos metodos vienen de nuestra clase abstracta (con el add se a�adieron de
	// forma automatica):
	@Override // el override significa que se esta usando un metro de la clase padre
	public double getTicketPrice() {
		double priceTicket;
		System.out.println("Precio Adulto: $" + adultTicket);

		if (age >= 18 && !student) {
			priceTicket = adultTicket;
		} else if (age >= 18 && student) {
			priceTicket = studentTicket;
			System.out.println("Precio Estudiante: $" + studentTicket);
		} else {
			priceTicket = childTicket;
			System.out.println("Precio Ni�os: $" + childTicket);
		}
		return priceTicket;
	}

	@Override
	public void printPriceDay() {
		// vamos imprimir:
		System.out.println(welcomeMessageString() + park + getPriceDay());
		// aqui uso la herencia llamando al metodo welcomeMessageString()

	}

	@Override
	public void printPriceDay(String authKey, String priceDay) {
		setPriceDay(priceDay);
		System.out.println(welcomeMessageString() + park + getPriceDay());
	}

}
