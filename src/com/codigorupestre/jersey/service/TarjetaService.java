package com.codigorupestre.jersey.service;

import java.util.List;

import com.codigorupestre.jersey.factorymethod.entity.Tarjeta;

public interface TarjetaService {
	
	public boolean crearTarjeta(Tarjeta tarjeta);
	
	public List<Tarjeta> obtenerTarjetas();

}
