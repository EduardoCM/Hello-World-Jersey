package com.codigorupestre.jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codigorupestre.jersey.factorymethod.entity.Tarjeta;
import com.codigorupestre.jersey.service.TarjetaService;
import com.codigorupestre.jersey.service.TarjetaServiceImpl;

@Path("tarjeta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarjetaAPI {

	private TarjetaService tarjetaService = new TarjetaServiceImpl();

	@POST
	public Tarjeta guardarTarjeta(Tarjeta tarjeta) {
		tarjetaService.crearTarjeta(tarjeta);
		return tarjeta;
	}

	@GET
	public List<Tarjeta> obtenerTarjetas() {
		return tarjetaService.obtenerTarjetas();
	}

}
