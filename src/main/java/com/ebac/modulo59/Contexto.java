package com.ebac.modulo59;

import com.ebac.modulo59.dto.Direccion;
import com.ebac.modulo59.model.DireccionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Contexto {

    static Connection connection;

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/modulo59";
        String user = "root";
        String password = "root";

        MysqlConnection mysqlConnection = new MysqlConnection();
        connection = mysqlConnection.getConnection(url, user, password);

        operacionConDirecciones();

        connection.close();


    }

    public static void operacionConDirecciones() throws SQLException {


        Direccion direccionJalisco = crearDireccion(1, "Emiliano Zapata", 24, "Jalisco");
        Direccion direccionZacatecas = crearDireccion(2, "Francisco Villa", 101, "Zacatecas");

        DireccionModel direccionModel = new DireccionModel(connection);
        Direccion direccion1 = direccionModel.guardar(direccionJalisco);
        Direccion direccion2 = direccionModel.guardar(direccionZacatecas);

//        direccion1.setIdDireccion(getIdDireccion(direccion1.getIdUsuario()));
//        direccion2.setIdDireccion(getIdDireccion(direccion2.getIdUsuario()));

        System.out.println(direccion1);
        System.out.println(direccion2);
        System.out.println("-------------------");

        Direccion primeraDireccion = direccionModel.obtenerPorId(1);
        Direccion segundaDireccion = direccionModel.obtenerPorId(2);

        System.out.println(primeraDireccion);
        System.out.println(segundaDireccion);
        System.out.println("-------------------");

        Direccion nuevaDireccion = crearDireccion(2,"Cerrada de los pinos",5,"Querétaro");
        nuevaDireccion.setIdDireccion(2);

        direccionModel.actualizarPorId(nuevaDireccion);

        Direccion direccionActualizada = direccionModel.obtenerPorId(2);

        System.out.println(direccionActualizada);
        System.out.println("-------------------");

        direccionModel.eliminarPorId(2);
        System.out.println(direccionModel.obtenerPorId(2));

    }

    private static Direccion crearDireccion(int idUsuario, String calle, int numero, String estado) {
        Direccion direccion = new Direccion();
        direccion.setIdUsuario(idUsuario);
        direccion.setCalle(calle);
        direccion.setNumero(numero);
        direccion.setEstado(estado);

        return direccion;

    }

    private static int getIdDireccion(int id) throws SQLException {

        String sql = "SELECT idDireccion FROM direcciones WHERE idUsuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        int idDireccion = 0;
        while(resultSet.next()) {
            idDireccion = resultSet.getInt("idDireccion");
        }


        return idDireccion;
    }
}
