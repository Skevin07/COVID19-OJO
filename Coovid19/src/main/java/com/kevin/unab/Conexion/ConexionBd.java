package com.kevin.unab.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBd {
	
	private Connection conectar;

	public ConexionBd() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conectar = DriverManager.getConnection("jdbc:mysql://localhost/covid19", "root", "root");
			System.out.println("Conexion exitosa");

		} catch (Exception e) {
			System.out.println("Error en la conexion " + e);
		}
	}

	public Connection RetornarConexion() {
		return conectar;
	}
}


