package com.kevin.unab.Negocio;

import com.kevin.unab.DAO.ClsBeneficiario;
import com.kevin.unab.Entidades.Persona;

public class ClsConsultar {

	public int SoyBeneficiario(Persona personaa) {
		
		int es = 0;
		
		ClsBeneficiario clsBeneficiario = new ClsBeneficiario();
		
		var ganador = clsBeneficiario.ObtenerBeneficiario(personaa);
		
		if(ganador == true) {
			es = 1;
		}
		
		return es;
	}
	
}
