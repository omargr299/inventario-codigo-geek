package com.inv.inventario.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;

public class PropietarioCreateDto {
		private int idPropietario;
	  	@Pattern(regexp = "[a-z0-9\\s]+",message="El nombre del propietario debe ser unicamente letras minusculas sin acentos o numeros")
		private String nombre;
	  	@Pattern(regexp = "[a-z0-9\\s]+",message="El aepllido paterno del propietario debe ser unicamente letras minusculas sin acentos o numeros")
	    private String apellidoPaterno;
	  	@Pattern(regexp = "[a-z0-9\\s]+",message="El aepllido materno del propietario debe ser unicamente letras minusculas sin acentos o numeros")
	    private String apellidoMaterno;
		public PropietarioCreateDto(int idPropietario,
				 String nombre,
				 String apellidoPaterno,
		 String apellidoMaterno) {
			super();
			this.idPropietario = idPropietario;
			this.nombre = nombre;
			this.apellidoPaterno = apellidoPaterno;
			this.apellidoMaterno = apellidoMaterno;
		}
		public int getIdPropietario() {
			return idPropietario;
		}
		public void setIdPropietario(int idPropietario) {
			this.idPropietario = idPropietario;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellidoPaterno() {
			return apellidoPaterno;
		}
		public void setApellidoPaterno(String apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
		}
		public String getApellidoMaterno() {
			return apellidoMaterno;
		}
		public void setApellidoMaterno(String apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
		}
	  	
	  	
}
