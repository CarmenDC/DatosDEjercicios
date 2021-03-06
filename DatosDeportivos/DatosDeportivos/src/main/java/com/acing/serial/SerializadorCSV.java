package com.acing.serial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.eventos.Participante;

public class SerializadorCSV {

	public static Collection<Evento> getEventos(String rutaArchivo){
		Collection<Evento> eventosLeidos = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(rutaArchivo),
						"UTF-8"))){
			
			String linea = reader.readLine();// Leo la primera linea
			while((linea = reader.readLine()) != null) {
				eventosLeidos.add(deserializarEvento(linea));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return eventosLeidos;
	}
	
	
	public static Evento deserializarEvento(String linea) throws ParseException {
		String[] campos = linea.split(",");
		String fechaString = campos[1];
		String localString = campos[2];
		String visitanteString = campos[3];
		String golesLocalString = campos[4];
		String golesVisitanteString = campos[5];
		
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yy");
		
		Date fecha = sdformat.parse(fechaString);

		Participante local = new Participante(localString);
		local.annadirParticipante(local);
	
		Participante visitante = new Participante(visitanteString);
		visitante.annadirParticipante(visitante);

		int golesLocal = Integer.parseInt(golesLocalString);
		int golesVisitante = Integer.parseInt(golesVisitanteString);
		String resultado = golesLocal + "-" + golesVisitante;
		
		
		Evento miEvento = new Evento(local, visitante, fecha);
		miEvento.setResultado(resultado);
		
		return miEvento;
	}
}
