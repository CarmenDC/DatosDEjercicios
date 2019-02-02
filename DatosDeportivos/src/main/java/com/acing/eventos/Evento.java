package com.acing.eventos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.acing.serial.Datable;

public class Evento implements Datable {
	
	
	transient private Participante localParticipante;
	transient private Participante visitanteParticipante;
	
	String local;
	String visitante;
	
	transient private Date fechaDate;
	private Fecha fecha = new Fecha();
	private String resultado;
	
	
	@Override
	public Fecha getFecha() {
		Fecha fecha = new Fecha();
		SimpleDateFormat sdformatDia= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdformatHora = new SimpleDateFormat("HH:mm");
		fecha.hora = sdformatHora.format(fechaDate);
		fecha.dia = sdformatDia.format(fechaDate);
		return fecha;
	}

	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public Evento() {}
	
	public Evento(Participante local, Participante visitante, Date fecha) {
		super();
		this.fechaDate = fecha;
		this.fecha = getFecha();
		this.localParticipante = local;				
		this.visitanteParticipante = visitante;
		this.local = local.getIdentificador();				
		this.visitante = visitante.getIdentificador();
	}

	@Override
	public String toString() {
		return "("+ fecha.dia +" "+fecha.hora + ") " + local + " vs " + visitante + " => " + resultado;
	}

	
}
