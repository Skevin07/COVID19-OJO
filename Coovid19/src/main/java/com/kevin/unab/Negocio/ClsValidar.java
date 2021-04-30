package com.kevin.unab.Negocio;

import com.kevin.unab.DAO.ClsPersona;

public class ClsValidar {

	public int AccesoLogin(String Usuario, String Contrasenia) {

		int Paso = 0;
		ClsPersona clsPersona = new ClsPersona();

		var validar = clsPersona.LoguinPersona(Usuario, Contrasenia);

		if (validar == true) {
			Paso = 1;
		}

		return Paso;
	}

}
