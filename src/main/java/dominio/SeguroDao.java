package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;


public class SeguroDao {
    private static final String insert = "INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES (?,?,?,?)";

    public boolean agregarSeguro(Seguro seguro) {
        boolean agregado = false;
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = Conexion.getSQLConexion();
            statement = conexion.prepareStatement(insert);
            statement.setString(1, seguro.getDescripcion());
            statement.setInt(2, seguro.getIdTipo());
            statement.setFloat(3, seguro.getCostoContratacion());
            statement.setFloat(4, seguro.getCostoAsegurado());

            if (statement.executeUpdate() > 0) {
                conexion.commit();
                agregado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) conexion.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return agregado;
    }

    public int obtenerProximoId() {
        int proximoId = 1;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'segurosgroup' AND TABLE_NAME = 'seguros'";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getSQLConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                proximoId = rs.getInt("AUTO_INCREMENT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return proximoId;
    }
    
    public ArrayList<Seguro> obtenerSeguros() {
        ArrayList<Seguro> lista = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String consulta = "SELECT s.idSeguro, s.descripcion, ts.descripcion AS DescripcionTipo, "
                        + "s.costoContratacion, s.costoAsegurado "
                        + "FROM seguros s JOIN tiposeguros ts ON s.idTipo = ts.idTipo "
                        + "ORDER BY s.idSeguro ASC";

        try {
            conexion = Conexion.getSQLConexion();
            statement = conexion.prepareStatement(consulta);
            rs = statement.executeQuery();

            while (rs.next()) {
                Seguro seguro = new Seguro();
                seguro.setIdSeguro(rs.getInt("idSeguro"));
                seguro.setDescripcion(rs.getString("descripcion"));
                seguro.setDescripcionTipo(rs.getString("DescripcionTipo"));
                seguro.setCostoContratacion(rs.getFloat("costoContratacion"));
                seguro.setCostoAsegurado(rs.getFloat("costoAsegurado"));
                lista.add(seguro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

}
	
	

