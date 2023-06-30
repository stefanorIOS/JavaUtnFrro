package ui;

import java.util.Scanner;

import data.*;
import entities.Bebida;
import entities.Cliente;
import entities.Empleado;
import entities.Plato;

public class Menu {

	Scanner s = null;
	BebidaDAO b = new BebidaDAO();
	PlatoDAO p = new PlatoDAO();
	ClienteDAO c = new ClienteDAO();
	EmpleadoDAO e = new EmpleadoDAO();
	
	
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
		case "listBebida":
			System.out.println(b.getAll());
			break;
			
		case "listPlato":
			System.out.println(p.getAll());
			break;
		
		case "listCliente":
			System.out.println(c.getAll());
			break;
			
		case "listEmpleado":
			System.out.println(e.getAll());
			break;
		
		case "newBebida":
			b.newBebida(this.newBeb());
			System.out.println(b.getAll());
			break;
			
		case "newPlato":
			p.newPlato(this.newPla());
			System.out.println(p.getAll());
			break;
			
		case "newCliente":
			c.newCliente(this.newCliente());
			System.out.println(c.getAll());
			break;
			
		case "newEmpleado":
			e.newEmpleado(this.newEmpleado());
			System.out.println(e.getAll());
			break;
			
		case "deleteBebida":
			b.delteBebida(this.delBeb());
			System.out.println(b.getAll());
			break;
		
		case "deletePlato":
			p.delPlato(this.delPlato());
			System.out.println(p.getAll());
			break;
		
		case "deleteCliente":
			c.delCliente(this.delCliente());
			System.out.println(c.getAll());
			break;
		
		case "updatePlato":
			p.updateBebida(this.updP());
			System.out.println(p.getAll());
			break;
		
		case "updateBebida":
			b.updateBebida(this.updB());
			System.out.println(b.getAll());
			break;
		
		case "updateCliente":
			c.updateCliente(this.updC());
			System.out.println(c.getAll());
			break;
		default:
			break;
		}
		}
	
		private String getCommand() {
			System.out.println("Ingrese el comando según la opción que desee realizar");
			System.out.println("listBebida / listPlato/ listCliente/ listEmpleado / newBebida / newPlato / newCliente / newEmpleado / deleteBebida / deletePlato / deleteCliente / updateBebida / updatePlato / updateCliente");
			
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
	
	private Plato newPla(){
		Plato p = new Plato();
		System.out.println("Ingrese los datos del plato");
		System.out.println("Nombre Plato");
		p.setNombre(s.nextLine());
		System.out.println("Receta");
		p.setReceta(s.nextLine());
		System.out.println("Precio plato");
		p.setPrecio(Float.parseFloat(s.nextLine()));
		System.out.println("Descripcion");
		p.setDescripcion(s.nextLine());
		return p;
		
	}
	
	private Cliente newCliente() {
		Cliente c = new Cliente();
		System.out.println("Ingrese dni de 8 digitos");
		c.setDni(s.nextLine());
		System.out.println("Ingrese nombre");
		c.setNombre(s.nextLine());
		System.out.println("Ingrese direccion");
		c.setDireccion(s.nextLine());
		return c;
	}
	
	private Empleado newEmpleado() {
		Empleado e = new Empleado();
		System.out.println("Ingrese dni de 8 digitos");
		e.setDni(s.nextLine());
		System.out.println("Ingrese nombre");
		e.setNombre(s.nextLine());
		System.out.println("Ingrese turno");
		e.setTurno(s.nextLine());
		return e;
	}
	
	
	private Bebida delBeb() {
		Bebida b = new Bebida();
		System.out.println("Ingrese bebida ID para borrar");
		b.setId(s.nextInt());
		return b;
	}
	
	private Plato delPlato() {
		Plato p = new Plato();
		System.out.println("Ingrese Plato ID para borrar");
		p.setId(s.nextInt());
		return p;
	}
	
	private Cliente delCliente() {
		Cliente c = new Cliente();
		System.out.println("Ingrese dni a buscar y borrar");
		c.setDni(s.nextLine());
		return c;
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
	
	private Plato updP() {
		Plato p = new Plato();
		
		System.out.println("Ingrese los datos del plato");
		System.out.println("ID a cambiar");
		p.setId(Integer.parseInt(s.nextLine()));
		System.out.println("Nombre Plato");
		p.setNombre(s.nextLine());
		System.out.println("Receta");
		p.setReceta(s.nextLine());
		System.out.println("Precio plato");
		p.setPrecio(Float.parseFloat(s.nextLine()));
		System.out.println("Descripcion");
		p.setDescripcion(s.nextLine());
		return p;
	}
	
	private Cliente updC() {
		Cliente c = new Cliente();
		System.out.println("Ingrese dni a modificar");
		c.setDni(s.nextLine());
		System.out.println("Ingrese nuevo nombre");
		c.setNombre(s.nextLine());
		System.out.println("Ingrese nueva direccion");
		c.setDireccion(s.nextLine());
		return c;
	}
	
		
}
