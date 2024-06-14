//package services;
//
//import DTOs.Especialidad;
//import utils.ConexionBD;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConsultaEspecialidad {
//
//    public static List<Especialidad> consultaEspecialidad() {
//
//        List<Especialidad> listaEspecialidad = new ArrayList<>();
//        String nomEspecialidad;
//
//        try (Connection miCon = ConexionBD.conectar()) {
//
//            PreparedStatement pstmt = miCon.prepareStatement("SELECT * FROM C1_ESPECIALIDAD ");
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                nomEspecialidad = rs.getString("NOMBRE_ESPE");
//
//                Especialidad especialidad = new Especialidad(nomEspecialidad);
//                listaEspecialidad.add(especialidad);
//            }
//
//        } catch (SQLException e) {
//            System.out.println();
//        }
//
//
//
//        return listaEspecialidad;
//    }
//
//}
