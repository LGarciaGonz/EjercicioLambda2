package services;

import DTOs.Profesor;
import utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaProfes {

    public static List<Profesor> consultaProfes(String especialidad) {

        List<Profesor> listaProfes = new ArrayList<>();
        String nomProfe, codEspecialidad;

        try (Connection miCon = ConexionBD.conectar()) {

            PreparedStatement pstmt = miCon.prepareStatement("SELECT * FROM C1_PROFESORES WHERE ESPECIALIDAD = ?");
            pstmt.setString(1, especialidad);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                nomProfe = rs.getString("NOMBRE_APE");

                Profesor profe = new Profesor(nomProfe, especialidad);
                listaProfes.add(profe);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaProfes;
    }


}
