package com.codigorupestre.jersey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MaestroService {
	
	private static Map<Integer, Maestro> alumnos = new HashMap<>();
	
	static {
		Maestro zoe = new Maestro(10221680, "Zoe", "Castillo Miranda", "Maestra de cientificos");	
		alumnos.put(1, zoe);
	}
	
	/*
	 * Obtener una lista de todos los maestros.
	 */
	@GET
	public List<Maestro> getAlumnos(){
		return new ArrayList<Maestro>(alumnos.values());
	}
	
	/*
	 * Obtener un alumnos por Id
	 */
	@GET
	@Path("/{alumnoId}")
	public Maestro getalumno(@PathParam("alumnoId") int alumnoId) {
		return alumnos.get(alumnoId);
	}
	
	
	/*
	 * Agregar un nuevo alumno
	 */
	@POST
	public void addAlumno(Maestro alumno) {
		alumnos.put(alumnos.size() + 1, alumno);
	}
	
	
	/*
	 * Actualizar un alumno
	 */
	@PUT
	@Path("/{alumnoId}")
	public void updateAlumno(@PathParam("alumnoId") int id, Maestro alumno) {
		alumnos.put(id, alumno);
	}
	
	
	/*
	 * Eliminar un alumno
	 */
	
	@DELETE
	@Path("/{alumnoId}")
	public void deleteAlumno(@PathParam("alumnoId") int id) {
		alumnos.remove(id);
	}

}