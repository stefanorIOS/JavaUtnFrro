package entities;

public class Bebida {
	int id;
	float precio;
	String nombre;
	float litros;
	
	public void BebidaB(int id, float precio, String nombre, float litros) {
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
		this.litros = litros;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getLitros() {
		return litros;
	}
	public void setLitros(float f) {
		this.litros = f;
	}
	
	@Override
	public String toString() {
		return "\n Bebida [id=" + id + ", precio=" + precio + ", nombre=" + nombre + ", litros=" + litros
				+ "]";
	}
	
}