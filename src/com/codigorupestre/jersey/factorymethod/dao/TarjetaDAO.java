package com.codigorupestre.jersey.factorymethod.dao;

import java.util.List;

import com.codigorupestre.jersey.factorymethod.entity.Tarjeta;

public interface TarjetaDAO {
	
	
	public List<Tarjeta> obtenerTarjetas();
	
	
	public boolean guardarTarjeta(Tarjeta tarjeta);

}
