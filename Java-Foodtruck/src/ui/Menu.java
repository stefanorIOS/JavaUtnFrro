package ui;

import java.util.Scanner;

import data.*;
import entities.Bebida;

public class Menu {

	Scanner s = null;
	BebidaDAO b = new BebidaDAO();
	
	
	public void start() {
		s = new Scanner(System.in);
		System.out.println("You're wolcome");
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
		
	}
	
	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(b.getAll());
			break;
		
		case "new":
			b.newBebida(this.newBeb());
			System.out.println(b.getAll());
			break;
			
		case "delete":
			b.delteBebida(this.delBeb());
			System.out.println(b.getAll());
			break;
		
		case "update":
			b.updateBebida(this.updB());
			System.out.println(b.getAll());
			break;
		
		default:
			break;
		}
		}
	
		private String getCommand() {
			System.out.println("Ingrese el comando según la opción que desee realizar");
			System.out.println("list / new / delete / update");
			
			/*System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
			System.out.println("search\t\tlistar por apellido"); //puede devolver varios
			System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
			System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
			System.out.println("delete\t\tborra por tipo y nro de documento");
			System.out.println();
		*/  System.out.print("comando: ");
			return s.nextLine();
		}
		
		
	private Bebida newBeb(){
		Bebida b = new Bebida();
		System.out.println("Ingrese los datos de la bebida");
		System.out.println("Precio Bebida");
		b.setPrecio(Float.parseFloat(s.nextLine()));
		System.out.println("Nombre Bebida");
		b.setNombre(s.nextLine());
		System.out.println("Litros Bebida");
		b.setLitros(Float.parseFloat(s.nextLine()));
		return b;
		
	}
	
	private Bebida delBeb() {
		Bebida b = new Bebida();
		System.out.println("Ingrese bebida ID para borrar");
		b.setId(s.nextInt());
		return b;
	}
	
	private Bebida updB() {
		Bebida b = new Bebida();
		System.out.println("Ingrese los datos de la bebida");
		System.out.println("ID a cambiar: ");
		b.setId(Integer.parseInt(s.nextLine()));
		System.out.println("Precio Bebida");
		b.setPrecio(Float.parseFloat(s.nextLine()));
		System.out.println("Nombre Bebida");
		b.setNombre(s.nextLine());
		System.out.println("Litros Bebida");
		b.setLitros(Float.parseFloat(s.nextLine()));
		return b;
	}
		
}
