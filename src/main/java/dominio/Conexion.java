package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	public static Conexion instancia;
	private Connection connection;
	
	private Conexion()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//pass: root / 1234 (mari)
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/segurosgroup","root","root");
			this.connection.setAutoCommit(false);
		}
		catch(Exception e)
		{	
			System.err.println("Error al conectar a la base de datos: " + e.getMessage());		    e.printStackTrace();
		    System.exit(1); //  Cierra todo el programa
		}
	}
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
