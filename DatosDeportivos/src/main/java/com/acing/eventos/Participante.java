package com.acing.eventos;

import java.util.HashMap;
import java.util.Map;

public class Participante implements Identificable<String>{
	
	transient private static Map<String,Participante> mapaParticipantes = new HashMap<>();
	
	transient private static int idnumero = 1;

	transient private String nombre;
	
	private String identificador;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Participante() {
	}
	
	public Participante(String nombre) {
		this.nombre = nombre;
		this.identificador = "" + idnumero;
		idnumero++;
	}


	@Override
	public String getIdentificador() {
		return identificador;
	}

	@Override
	public String toString() {
		return identificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}
	
	
	
	
	
}
