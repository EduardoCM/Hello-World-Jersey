package com.codigorupestre.jersey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("materias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MaestroService {
	
	private static List<Maestro> maestros = new ArrayList<>();
	
	static {
		Maestro jasmesGosling = new Maestro(10221680, "James", "Gosling", "Ciencias de la computacion");	
		maestros.add(jasmesGosling);
	}
	
	/*
	 * Obtener una lista de todos los maestros.
	 */
	@GET
	public List<Maestro> getAlumnos(){
		return maestros;
	}

}