package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Cliente;
import entities.Empleado;

public class EmpleadoDAO {
	
	public LinkedList<Empleado> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Empleado> Empleados= new LinkedList<>();	
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select dniEmpleado, nombre, turno from empleado");
			
			if(rs!=null) {
				while(rs.next()) {
					Empleado e = new Empleado();
					e.setDni(rs.getString("dniEmpleado"));
					e.setNombre(rs.getString("nombre"));
					e.setTurno(rs.getString("turno"));
					
					Empleados.add(e);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return Empleados;
	}
	//////////////////////////////////////
	
public void newEmpleado(Empleado newEmpleado) {
		
		
		PreparedStatement stmt=null;
		
		try {			
			
			
			stmt = DbConnector.getInstancia().getConn()
			.prepareStatement("insert into empleado (dniEmpleado, nombre, turno)" + "values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, newEmpleado.getDni());
			stmt.setString(2, newEmpleado.getNombre());
			stmt.setString(3, newEmpleado.getTurno());
			stmt.executeUpdate();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

///////////////////////////////////

public void delCliente(Cliente delCliente) {
	
	PreparedStatement stmt = null;
	try {

		stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from cliente where dniCliente=?");
		stmt.setString(1, delCliente.getDni());
		stmt.executeUpdate();

	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		try {
			if (stmt != null) {
				stmt.close();
			}
			DbConnector.getInstancia().releaseConn();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}



}
