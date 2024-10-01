package com.ebac.modulo59.model;

import com.ebac.modulo59.dto.Direccion;


import java.sql.*;

public class DireccionModel implements OperacionesCRUD<Direccion>{

    private final Connection connection;

    public DireccionModel(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Direccion guardar(Direccion direccion) throws SQLException {
        String sql = "INSERT INTO direcciones(idUsuario, calle, numero, estado) values(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,direccion.getIdUsuario());
        statement.setString(2, direccion.getCalle());
        statement.setInt(3,direccion.getNumero());
        statement.setString(4, direccion.getEstado());

        if(statement.executeUpdate() == 1) {
            return direccion;
        }

        throw new SQLException("Algo salio mal");
    }

    @Override
    public Direccion actualizarPorId(Direccion direccion) throws SQLException {
        String sql = "UPDATE direcciones SET idUsuario = ?, calle = ?, numero = ?, estado = ? WHERE idDireccion = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,direccion.getIdUsuario());
        statement.setString(2, direccion.getCalle());
        statement.setInt(3,direccion.getNumero());
        statement.setString(4, direccion.getEstado());
        statement.setInt(5, direccion.getIdDireccion());

        if(statement.executeUpdate() == 1) {
            return direccion;
        }

        throw new SQLException("Algo salio mal");
    }

    @Override
    public int eliminarPorId(int id) throws SQLException {
        String sql = "DELETE FROM direcciones WHERE idDireccion= ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);

        return statement.executeUpdate();
    }

    @Override
    public Direccion obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM direcciones WHERE idDireccion = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resulset = statement.executeQuery();

        Direccion direccion = new Direccion();
        while(resulset.next()) {
            direccion.setIdDireccion(resulset.getInt("idDireccion"));
            direccion.setIdUsuario(resulset.getInt("idUsuario"));
            direccion.setCalle(resulset.getString("calle"));
            direccion.setNumero(resulset.getInt("numero"));
            direccion.setEstado(resulset.getString("estado"));
        }


        return direccion;
    }
}
