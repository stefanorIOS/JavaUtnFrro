package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.*;

public class BebidaDAO {
	
	public LinkedList<Bebida> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Bebida> bebidas= new LinkedList<>();	
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idBebida, precioBebida, nombreBebida, litrosBebida from bebida");
			
			if(rs!=null) {
				while(rs.next()) {
					Bebida b = new Bebida();
					b.setId(rs.getInt("idBebida"));
					b.setPrecio(rs.getFloat("precioBebida"));
					b.setNombre(rs.getString("nombreBebida"));
					b.setLitros(rs.getFloat("litrosBebida"));
					
					bebidas.add(b);
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
		
		
		return bebidas;
	}
	
	//------------------------------------------------
	//agregar
	
	public void newBebida(Bebida newBebida) {
		
		ResultSet keyRS=null;
		PreparedStatement stmt=null;
		
		try {			
			
			
			stmt = DbConnector.getInstancia().getConn()
			.prepareStatement("insert into bebida (precioBebida, nombreBebida, litrosBebida)" + "values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setFloat(1, newBebida.getPrecio());
			stmt.setString(2, newBebida.getNombre());
			stmt.setFloat(3, newBebida.getLitros());
			stmt.executeUpdate();
			keyRS= stmt.getGeneratedKeys();
			
			if(keyRS != null && keyRS.next()) {
				newBebida.setId(keyRS.getInt(1));
			}
			
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
	
	public void delteBebida(Bebida delBeb) {
		
		PreparedStatement stmt = null;
		try {

			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from bebida where idBebida=?");
			stmt.setInt(1, delBeb.getId());
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
		
	
	public void updateBebida(Bebida updBebida) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("UPDATE bebida SET precioBebida=?, nombreBebida=?, litrosBebida=? where idBebida=?");
		stmt.setFloat(1, updBebida.getPrecio());
		stmt.setString(2, updBebida.getNombre() );
		stmt.setFloat(3, updBebida.getLitros());
		stmt.setInt(4, updBebida.getId());
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


	
	
	
	
	
	
	
	


	