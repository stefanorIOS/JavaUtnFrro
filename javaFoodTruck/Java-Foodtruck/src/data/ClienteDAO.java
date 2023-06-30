package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Cliente;
import entities.Plato;


public class ClienteDAO {

	public LinkedList<Cliente> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Cliente> clientes= new LinkedList<>();	
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select dniCliente, nombre, direccion from cliente");
			
			if(rs!=null) {
				while(rs.next()) {
					Cliente c = new Cliente();
					c.setDni(rs.getString("dniCliente"));
					c.setNombre(rs.getString("nombre"));
					c.setDireccion(rs.getString("direccion"));
					
					clientes.add(c);
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
		
		
		return clientes;

	}
	////////////////////////////////////////////////////
	
public void newCliente(Cliente newCliente) {
		
		
		PreparedStatement stmt=null;
		
		try {			
			
			
			stmt = DbConnector.getInstancia().getConn()
			.prepareStatement("insert into cliente (dniCliente, nombre, direccion)" + "values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, newCliente.getDni());
			stmt.setString(2, newCliente.getNombre());
			stmt.setString(3, newCliente.getDireccion());
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

//////////////////////////

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

//////////////////////

public void updateCliente(Cliente updCliente) {
	PreparedStatement stmt = null;
	try {
		stmt = DbConnector.getInstancia().getConn()
				.prepareStatement("UPDATE cliente SET nombre=?, direccion=? where dniCliente=?");
	stmt.setString(3, updCliente.getDni());
	stmt.setString(1, updCliente.getNombre() );
	stmt.setString(2, updCliente.getDireccion());
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