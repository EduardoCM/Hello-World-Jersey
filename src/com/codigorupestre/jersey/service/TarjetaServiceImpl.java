package com.codigorupestre.jersey.service;

import java.util.List;

import com.codigorupestre.jersey.factorymethod.dao.TarjetaDAO;
import com.codigorupestre.jersey.factorymethod.dao.TarjetaDAOImpl;
import com.codigorupestre.jersey.factorymethod.entity.Tarjeta;

public class TarjetaServiceImpl implements TarjetaService {

	TarjetaDAO dao = new TarjetaDAOImpl();

	@Override
	public boolean crearTarjeta(Tarjeta tarjeta) {
		return dao.guardarTarjeta(tarjeta);
	}

	@Override
	public List<Tarjeta> obtenerTarjetas() {
		return dao.obtenerTarjetas();
	}



}
