package dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoSeguroDao {

    private static final String obtenerTodos = "SELECT idTipo, descripcion FROM tipoSeguros";

    public List<TipoSeguro> obtenerTodos() {
        List<TipoSeguro> lista = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = Conexion.getSQLConexion();
            statement = conexion.prepareStatement(obtenerTodos);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TipoSeguro tipo = new TipoSeguro();
                tipo.setIdTipo(resultSet.getInt("idTipo"));
                tipo.setDescripcion(resultSet.getString("descripcion"));
                lista.add(tipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}