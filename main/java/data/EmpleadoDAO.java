package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Empleado;
import entities.Rol;

public class EmpleadoDAO {
	
	public LinkedList<Empleado> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Empleado> empleados = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT dniEmpleado, nombre, turno, habilitado FROM Empleado order by habilitado desc, turno asc ");
			RolDAO rdao = new RolDAO();
			
			if (rs != null) {
				while (rs.next()) {

					Empleado e = new Empleado();

					e.setDni(rs.getString("dniEmpleado"));
					e.setNombre(rs.getString("nombre"));
					e.setTurno(rs.getString("turno"));
					e.setHabilitado(rs.getBoolean("habilitado"));
					

					rdao.setRoles(e);
					
					empleados.add(e);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return empleados;

	}
	
	public Empleado getEmpleado(Empleado emp) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Empleado e = null;
		RolDAO rdao = new RolDAO();
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("Select * from Empleado WHERE dniEmpleado=?");

			stmt.setString(1, emp.getDni());

			rs = stmt.executeQuery();

			if (rs != null & rs.next()) {

				e = new Empleado();
				e.setDni(rs.getString("dniEmpleado"));
				e.setNombre(rs.getString("nombre"));
				e.setTurno(rs.getString("turno"));
				e.setHabilitado(rs.getBoolean("habilitado"));
				
				rdao.setRoles(e);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return e;
	}
	
	public void newEmpleado(Empleado e) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO Empleado (dniEmpleado,nombre, turno, password, habilitado) VALUES (?,?,?,?,1)");

			stmt.setString(1, e.getDni());
			stmt.setString(2, e.getNombre());
			stmt.setString(3, e.getTurno());
			stmt.setString(4, e.getPassword());

			stmt.executeUpdate();
			
			for (Rol r : e.getColeccionRoles()) {
				
				stmt = DbConnector.getInstancia().getConn()
						.prepareStatement("INSERT INTO empleado_rol (dniEmpleado,idRol) VALUES (?,?)");
				
				stmt.setString(1, e.getDni());
				stmt.setInt(2, r.getId());

				stmt.executeUpdate();
			}
			

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
	
	public void updateEmpleado(Empleado e) {

		PreparedStatement stmt = null;
		RolDAO rdao = new RolDAO();
		try {

			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("UPDATE Empleado SET dniEmpleado=?, nombre=?, turno=?, password=? where dniEmpleado=?");
			stmt.setString(1, e.getDni());
			stmt.setString(2, e.getNombre());
			stmt.setString(3, e.getTurno());
			stmt.setString(4, e.getPassword());
			stmt.setString(5, e.getDni());
			
			stmt.executeUpdate();
			
			rdao.deleteRolEmpleado(e);
			
			for (Rol r : e.getColeccionRoles()) {
				
				stmt = DbConnector.getInstancia().getConn()
						.prepareStatement("INSERT INTO empleado_rol (dniEmpleado,idRol) VALUES (?,?)");
				
				stmt.setString(1, e.getDni());
				stmt.setInt(2, r.getId());

				stmt.executeUpdate();
			}
			

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
	
	public void deleteEmpleado(Empleado e) {

		PreparedStatement stmt = null;
		try {

			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE from Empleado WHERE dniEmpleado=?");
			stmt.setString(1, e.getDni());
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
	
	public Empleado login(Empleado emp) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Empleado e = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("Select dniEmpleado,nombre, turno from Empleado WHERE dniEmpleado=? and password=?");

			stmt.setString(1, emp.getDni());
			stmt.setString(2, emp.getPassword());

			rs = stmt.executeQuery();

			if (rs != null & rs.next()) {

				e = new Empleado();
				e.setDni(rs.getString("dniEmpleado"));
				e.setNombre(rs.getString("nombre"));
				e.setTurno(rs.getString("turno"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return e;
	}
	
	public void deshabilitarEmpleado(Empleado emp) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE empleado set habilitado=0 where dniEmpleado=?");
			stmt.setString(1, emp.getDni());
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
	
	public void habilitarEmpleado(Empleado emp) {
		PreparedStatement stmt = null;
		
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE empleado set habilitado=1 where dniEmpleado=?");
			stmt.setString(1, emp.getDni());
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
