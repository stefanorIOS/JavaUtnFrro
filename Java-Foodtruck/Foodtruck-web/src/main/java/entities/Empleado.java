package entities;

public class Empleado {

	private String dni;
	private String nombre;
	private String turno;
	private String password;
	
	public Empleado() {
		
	}
	
	public Empleado (String dni, String nombre, String turno, String p){
		this.dni = dni;
		this.nombre = nombre;
		this.turno = turno;
		this.password = p;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	public String getPassword() {
		return password;
	}

	
	
}
