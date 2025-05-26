package dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class SeguroDao {
	private static final String insert= "INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES (?,?,?,?)";
	
	
	public boolean agregarSeguro(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion= Conexion.getConexion().getSQLConexion();
		boolean agregar= false;
	
	try {
		statement= conexion.prepareStatement(insert);
		statement.setString(1, seguro.getDescripcion());
		statement.setInt(2, seguro.getIdTipo());
		statement.setFloat(3, seguro.getCostoContratacion());
		statement.setFloat(4, seguro.getCostoAsegurado());

    if (statement.executeUpdate() > 0) {
    	conexion.commit();
        agregar = true;
    }
	} catch (SQLException e) {
    e.printStackTrace();
	
    try {
       conexion.rollback();
	    } catch (SQLException e1) {
	        e.printStackTrace();
	    }
	}

	
	return agregar;
	}
	
	public int obtenerProximoId() {
	    int proximoId = 1; // valor por defecto si no hay registros
	    String sql = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'segurosgroup' AND TABLE_NAME = 'seguros'";
	    try (Connection con = Conexion.getConexion().getSQLConexion();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        if (rs.next()) {
	            proximoId = rs.getInt("AUTO_INCREMENT");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return proximoId;
	}
	
	
}
	
	

