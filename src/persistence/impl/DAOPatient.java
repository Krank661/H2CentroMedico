package persistence.impl;

import enums.BloodTypes;
import model.impl.Patient;
import org.apache.log4j.Logger;
import persistence.IDAOPatient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPatient implements IDAOPatient {

    public static Logger logger = Logger.getLogger(DAOPatient.class);
    static String URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    static String USER = "sa";
    static String PASS = "";

    @Override
    public List<Patient> getAll() {

        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        List<Patient> patients = new ArrayList<>();
        String SQL_SELECT_ALL = "SELECT * FROM pacientes";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);

            while (rs.next()) {
                Patient p = new Patient();

                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("nombre"));
                p.setPhoneNumber(rs.getString("telefono"));
                p.setBloodType(BloodTypes.valueOf(rs.getString("grupo_sanguineo")));
                p.setAge(rs.getInt("edad"));

                patients.add(p);
            }

        } catch (SQLException ex) {
            logger.error("Error: se ha producido un error al consultar los registros.");
        }

        return patients;
    }

    @Override
    public Patient getByID(String dni) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        Patient p = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement("SELECT * FROM pacientes WHERE dni = ?")) {

            filter.setString(1, dni);
            ResultSet rs = filter.executeQuery();

            if (rs.next()) {
                p = new Patient();

                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("nombre"));
                p.setPhoneNumber(rs.getString("telefono"));
                p.setBloodType(BloodTypes.valueOf(rs.getString("grupo_sanguineo")));
                p.setAge(rs.getInt("edad"));
            }

        } catch (SQLException ex) {
            logger.error("Error: se ha producido un error al consultar los registros por dni.");
        }

        return p;
    }


    @Override
    public int create(Patient patient) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        int affectedRows = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement("INSERT INTO pacientes (dni, nombre, telefono, grupo_sanguineo, edad) VALUES (?, ?, ?, ?, ?)")) {

            filter.setString(1, patient.getDni());
            filter.setString(2, patient.getName());
            filter.setString(3, patient.getPhoneNumber());
            filter.setString(4, patient.getBloodType().toString());
            filter.setInt(5, patient.getAge());

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido guardar el nuevo paciente.");
        }

        return affectedRows;
    }

    @Override
    public int update(Patient patient) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        int affectedRows = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement("UPDATE pacientes SET nombre = ?, telefono = ?, grupo_sanguineo = ?, edad = ? WHERE dni = ?")) {

            filter.setString(1, patient.getName());
            filter.setString(2, patient.getPhoneNumber());
            filter.setString(3, patient.getBloodType().toString());
            filter.setInt(4, patient.getAge());
            filter.setString(5, patient.getDni());

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido guardar el nuevo paciente.");
        }
        return affectedRows;
    }

    @Override
    public int delete(String dni) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        int affectedRows = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement("DELETE FROM pacientes WHERE dni = ?")) {

            filter.setString(1, dni);

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido borrar el registro.");
        }
        return affectedRows;
    }

    @Override
    public List<Patient> getByName(String name) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        List<Patient> patients = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement("SELECT * FROM pacientes WHERE nombre = ?")) {

            filter.setString(1, name);
            ResultSet rs = filter.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();

                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("nombre"));
                p.setPhoneNumber(rs.getString("telefono"));
                p.setBloodType(BloodTypes.valueOf(rs.getString("grupo_sanguineo")));
                p.setAge(rs.getInt("edad"));

                patients.add(p);
            }
        } catch (SQLException ex) {
            logger.error("Error: se ha producido un error al consultar los registros.");
        }

        return patients;
    }

    @Override
    public List<Patient> getByPhoneNumber(String phoneNumber) {
        logger.info("Registrando el driver");
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }

        List<Patient> patients = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement filter = conn.prepareStatement("SELECT * FROM pacientes WHERE telefono = ?")){

            filter.setString(1, phoneNumber);
            ResultSet rs = filter.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();

                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("nombre"));
                p.setPhoneNumber(rs.getString("telefono"));
                p.setBloodType(BloodTypes.valueOf(rs.getString("grupo_sanguineo")));
                p.setAge(rs.getInt("edad"));

                patients.add(p);
            }

        } catch (SQLException ex) {
            logger.error("Error: se ha producido un error al consultar los registros.");
        }

        return patients;
    }
}
