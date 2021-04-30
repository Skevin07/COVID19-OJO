package com.kevin.unab.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.kevin.unab.Conexion.ConexionBd;
import com.kevin.unab.Entidades.Persona;

public class ClsBeneficiario {

	
	ConexionBd claseConectar = new ConexionBd();
    Connection conectar = claseConectar.RetornarConexion();
    
    public boolean ObtenerBeneficiario(Persona person){
    	
    	boolean esbenefi = false;
    	try {
			CallableStatement statement = conectar.prepareCall("call Sp_S_Join(?)");
			statement.setString("PDUI", person.getDUI());
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				esbenefi = true;
			}
		} catch (Exception e) {
			System.out.println("error" + e);
		}
    	return esbenefi;
    }
    
    
    
    public String MostrarBeneficiario(Persona person) {
    	
    	String namel = "";
    	try {
			CallableStatement statement = conectar.prepareCall("call Sp_S_AmIBeneficiary(?)");
			statement.setString("PDUI", person.getDUI());
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				namel = result.getString("namel");
			}
		} catch (Exception e) {
			System.out.println("error" + e);
		}
    	return namel;
    }
	
}
