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
		if (mapaParticipantes.containsKey(nombre)){
			System.out.println(nombre);
			this.identificador = mapaParticipantes.get(nombre).getIdentificador();
		}
		else {
		this.identificador = "" + idnumero;
		idnumero++;
		}
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
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public void annadirParticipante (Participante participante) {
		mapaParticipantes.put(nombre, participante);
		
	}
	
	
	
}
