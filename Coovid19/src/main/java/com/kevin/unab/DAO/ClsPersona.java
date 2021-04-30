package com.kevin.unab.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kevin.unab.Conexion.ConexionBd;
import com.kevin.unab.Entidades.Persona;

public class ClsPersona {
	
	ConexionBd claseConectar = new ConexionBd();
    Connection conectar = claseConectar.RetornarConexion();
    
    
    public boolean LoguinPersona(String Usuario, String Password) {

        ArrayList<Persona> ListadoUSUARIO = new ArrayList<>();
        ArrayList<Persona> ListarContra = new ArrayList<>();

        
        try {
            CallableStatement Statement = conectar.prepareCall("call Sp_S_Inicio(?,?)");
            Statement.setString("pUsuario", Usuario);
            Statement.setString("pContrasenia", Password);
            ResultSet resulConsulta = Statement.executeQuery();
            while (resulConsulta.next()) {

            	
                Persona person = new Persona();
                person.setUsuario(resulConsulta.getString("Usuario"));
                person.setContrasenia(resulConsulta.getString("Contrasenia"));
                ListadoUSUARIO.add(person);
            }

            
            String usuarioBD = null;
            String contraseniaBD = null;
            for (var iterar : ListadoUSUARIO) {

            	usuarioBD = iterar.getUsuario();
            	contraseniaBD = iterar.getContrasenia();
            }

            
            
            CallableStatement st2 = conectar.prepareCall("call Sp_S_SavePersona(?)");
            st2.setString("PContrasenia", Password);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Persona crip = new Persona();
                crip.setContrasenia(rs2.getNString("crip"));
                ListarContra.add(crip);
            }

            
            
            String PAScri = null;
            for (var iterar : ListarContra) {

            	PAScri = iterar.getContrasenia();
                Password = PAScri;
            }

            if (usuarioBD != null && contraseniaBD != null) {
                if (usuarioBD.equals(Usuario) && contraseniaBD.equals(Password)) {
                    return true;
                }
            }
            conectar.close();

        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return false;
    }

}
