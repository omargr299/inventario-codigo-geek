package com.inv.inventario.Dtos;

import jakarta.validation.constraints.Pattern;

public class UbicacionCresteDto {
	@Pattern(regexp = "[a-z0-9\\s]+",message="La calle debe ser unicamente letras minusculas sin acentos o numeros")
	 private String calle;
	 private int numero;
		@Pattern(regexp = "[a-z0-9\\s]+",message="La colonia debe ser unicamente letras minusculas sin acentos o numeros")
	 private String colonia;
		@Pattern(regexp = "[a-z0-9\\s]+",message="El municipio debe ser unicamente letras minusculas sin acentos o numeros")
	 private String municipio;
		@Pattern(regexp = "[a-z\\s]+",message="El estado debe ser unicamente letras minusculas sin acentos")
	 private String estado;
	 private int cp;
	public UbicacionCresteDto(
			@Pattern(regexp = "[a-z0-9\\s]+", message = "La calle debe ser unicamente letras minusculas sin acentos o numeros") String calle,
			int numero,
			@Pattern(regexp = "[a-z0-9\\s]+", message = "La colonia debe ser unicamente letras minusculas sin acentos o numeros") String colonia,
			@Pattern(regexp = "[a-z0-9\\s]+", message = "El municipio debe ser unicamente letras minusculas sin acentos o numeros") String municipio,
			@Pattern(regexp = "[a-z\\s]+", message = "El estado debe ser unicamente letras minusculas sin acentos") String estado,
			int cp) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.colonia = colonia;
		this.municipio = municipio;
		this.estado = estado;
		this.cp = cp;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	 
	 
}
