package persistence.impl;

import enums.Specialties;
import model.impl.Doctor;
import org.apache.log4j.Logger;
import persistence.IDAODoctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODoctor implements IDAODoctor {
    public static Logger logger = Logger.getLogger(DAODoctor.class);
    static String URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    static String USER = "sa";
    static String PASS = "";
    @Override
    public List<Doctor> getAll() {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM profesionales_de_la_salud WHERE profesion = 'medico'";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement(query)) {
            ResultSet rs = filter.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();

                doctor.setId(rs.getInt("id"));
                doctor.setDni(rs.getString("dni"));
                doctor.setName(rs.getString("nombre"));
                doctor.setPhoneNumber(rs.getString("telefono"));
                doctor.setSpecialty(Specialties.valueOf("especialidad"));
            }
        } catch (SQLException ex) {
            logger.error("Error: se ha producido un error al consultar los registros.");
        }

        return doctors;
    }

    @Override
    public Doctor getByID(Integer id) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        Doctor doctor = null;
        String query = "SELECT * FROM profesionales_de_la_salud WHERE id = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement(query)) {

            filter.setInt(1, id);
            ResultSet rs = filter.executeQuery();

            if(rs.next()) {
                doctor = new Doctor();

                doctor.setId(rs.getInt("id"));
                doctor.setDni(rs.getString("dni"));
                doctor.setName(rs.getString("nombre"));
                doctor.setPhoneNumber(rs.getString("telefono"));
                doctor.setSpecialty(Specialties.valueOf("especialidad"));
            }
        } catch (SQLException ex) {
            logger.error("Error: se ha producido un error al consultar los registros.");
        }

        return doctor;
    }

    @Override
    public int create(Doctor doctor) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        int affectedRows = 0;
        String query = "INSERT INTO profesionales_de_la_salud(id, dni, nombre, telefono, especialidad, profesion) VALUES(?, ?, ?, ?, ?, 'médico')";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement(query)) {
            filter.setInt(1, doctor.getId());
            filter.setString(2, doctor.getDni());
            filter.setString(3, doctor.getName());
            filter.setString(4, doctor.getPhoneNumber());
            filter.setString(5, doctor.getSpecialty().toString());

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido guardar el médico.");
        }

        return affectedRows;
    }

    @Override
    public int update(Doctor doctor) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        int affectedRows = 0;
        String query = "UPDATE profesionales_de_la_salud SET dni = ?, nombre = ?, telefono = ?, especialidad = ? WHERE id = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement(query)) {
            filter.setString(1, doctor.getDni());
            filter.setString(2, doctor.getName());
            filter.setString(3, doctor.getPhoneNumber());
            filter.setString(4, doctor.getSpecialty().toString());
            filter.setInt(5, doctor.getId());

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido actualizar los datos del médico.");
        }
        return affectedRows;
    }

    @Override
    public int delete(Integer id) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        int affectedRows = 0;
        String query = "DELETE FROM profesionales_la_salud WHERE id = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement(query)) {
            filter.setInt(1, id);

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido borrar el médico.");
        }
        return affectedRows;
    }

    @Override
    public List<Doctor> getBySpecialty(Specialties specialty) {

        return null;
    }
}
