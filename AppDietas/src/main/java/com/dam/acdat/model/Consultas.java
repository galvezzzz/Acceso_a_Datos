package com.dam.acdat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

    public void consulta1() {
        String sql = "SELECT Clientes.nombre, Clientes.fecha_nacimiento, Clientes.telefono, Clientes.email\n" +
                "FROM Clientes\n" +
                "JOIN CentrosDieteticos ON Clientes.centro_dietetico_id = CentrosDieteticos.id\n" +
                "WHERE CentrosDieteticos.nombre = 'Bienestar y Salud'";


//    SELECT CentrosDieteticos.nombre AS Centro, COUNT(Clientes.id) AS TotalClientes
//    FROM CentrosDieteticos
//    LEFT JOIN Clientes ON CentrosDieteticos.id = Clientes.centro_dietetico_id
//    GROUP BY CentrosDieteticos.nombre;
//
//    CONCAT(FLOOR(YEAR(fecha_nacimiento) / 10) * 10, 's') AS decada:,
//    COUNT(*) AS TotalClientes
//    FROM Clientes
//    GROUP BY decada
//    ORDER BY decada;

    }
}
