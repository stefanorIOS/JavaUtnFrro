package entities;

public class Empleado {
	private String dni;
	private String nombre;
	private String turno;

	public Empleado() {

	}

	public Empleado (String dni, String nombre, String turno){
		this.dni = dni;
		this.nombre = nombre;
		this.turno = turno;
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
	
	public String toString() {
		return "\n dni [dni=" + dni + ", nombre=" + nombre + ", turno=" + turno +  "";
	}
}
