package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Empleado;

public class EmpleadoDAO {
	
	public LinkedList<Empleado> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Empleado> empleados = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Empleado");

			if (rs != null) {
				while (rs.next()) {

					Empleado e = new Empleado();

					e.setDni(rs.getString("dniEmpleado"));
					e.setNombre(rs.getString("nombre"));
					e.setTurno(rs.getString("turno"));

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
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("Select * from Empleado WHERE dniEmpleado=?");

			stmt.setString(1, emp.getDni());

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
	
	public void newEmpleado(Empleado e) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO Empleado (dniEmpleado,nombre, turno, password) VALUES (?,?,?,?)");

			stmt.setString(1, e.getDni());
			stmt.setString(2, e.getNombre());
			stmt.setString(3, e.getTurno());
			stmt.setString(4, e.getPassword());

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
	
	public void updateEmpleado(Empleado e) {

		PreparedStatement stmt = null;
		try {

			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("UPDATE Empleado SET dniEmpleado=?, nombre=?, turno=?, password=? where dniEmpleado=?");
			stmt.setString(1, e.getDni());
			stmt.setString(2, e.getNombre());
			stmt.setString(3, e.getTurno());
			stmt.setString(4, e.getPassword());
			stmt.setString(5, e.getDni());

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
	
	
	
	
	
	
	
}
