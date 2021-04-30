package com.kevin.unab.Entidades;

public class Beneficiario extends Persona{

	protected int idbeneficiario;
	protected Double Monto;
	
	public int getIdbeneficiario() {
		return idbeneficiario;
	}
	public void setIdbeneficiario(int idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}
	public Double getMonto() {
		return Monto;
	}
	public void setMonto(Double monto) {
		Monto = monto;
	}
	
}
