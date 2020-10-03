package com.codigorupestre.jersey.factorymethod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codigorupestre.jersey.factorymethod.DBFactory;
import com.codigorupestre.jersey.factorymethod.IDBAdapter;
import com.codigorupestre.jersey.factorymethod.entity.Tarjeta;

public class TarjetaDAOImpl implements TarjetaDAO {

	private IDBAdapter dbAdapter;

	public TarjetaDAOImpl() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	@Override
	public List<Tarjeta> obtenerTarjetas() {

		Connection connection = dbAdapter.getConnection();
		List<Tarjeta> tarjetasList = new ArrayList<>();

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT idTarjeta, numeroTarjeta, banco FROM tarjetas");

			ResultSet tarjetaResult = statement.executeQuery();

			while (tarjetaResult.next()) {
				tarjetasList.add(
						new Tarjeta(tarjetaResult.getInt(1), tarjetaResult.getString(2), tarjetaResult.getString(3)));
			}

			return tarjetasList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			
		}
	}

	@Override
	public boolean guardarTarjeta(Tarjeta tarjeta) {
		Connection connection = dbAdapter.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO tarjetas (numeroTarjeta, banco) VALUES (?,?)");

			statement.setString(1, tarjeta.getNumeroTarjeta());
			statement.setString(2, tarjeta.getBanco());
			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

	}

}
