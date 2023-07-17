package persistence.impl;

import enums.BloodTypes;
import model.impl.Patient;
import org.apache.log4j.Logger;
import persistence.IDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPatient implements IDAO<Patient, String> {

    public static Logger logger = Logger.getLogger(DAOPatient.class);

    static Connection conn;

    static String URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    static String USER = "sa";
    static String PASS = "";

    @Override
    public List<Patient> getAll() {

        logger.info("Registrando el driver y conectando a la base de datos.");
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido establecer conexión con la base de datos.");
        }

        List<Patient> patients = new ArrayList<>();
        String SQL_SELECT_ALL = "SELECT * FROM pacientes";

        try {
            Statement stmt = conn.createStatement();

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

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            logger.error("Error: se ha producido un error al consultar los registros.");
        }

        logger.info("Desconectando de la base de datos");
        try {
            conn.close();
        } catch (SQLException ex) {
            logger.error("Error: la conexión con la base de datos no ha podido finalizar correctamente.");
        }

        return patients;
    }

    @Override
    public Patient getByID(String dni) {
        logger.info("Registrando el driver y conectando a la base de datos.");
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido establecer conexión con la base de datos.");
        }

        Patient p = null;
        try {
            String query = "SELECT * FROM pacientes WHERE dni = ?";
            PreparedStatement filter = conn.prepareStatement(query);
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
            logger.error("Error: se ha producido un error al consultar los registros.");
        }

        logger.info("Desconectando de la base de datos");
        try {
            conn.close();
        } catch (SQLException ex) {
            logger.error("Error: la conexión con la base de datos no ha podido finalizar correctamente.");
        }
        return p;
    }

    @Override
    public int create(Patient patient) {
        logger.info("Registrando el driver y conectando a la base de datos.");
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido establecer conexión con la base de datos.");
        }

        int affectedRows = 0;

        try{
            String query = "INSERT INTO pacientes (dni, nombre, telefono, grupo_sanguineo, edad) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement filter = conn.prepareStatement(query);
            filter.setString(1, patient.getDni());
            filter.setString(2, patient.getName());
            filter.setString(3, patient.getPhoneNumber());
            filter.setString(4, patient.getBloodType().toString());
            filter.setInt(5, patient.getAge());

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido guardar el nuevo paciente.");
        }

        logger.info("Desconectando de la base de datos");
        try {
            conn.close();
        } catch (SQLException ex) {
            logger.error("Error: la conexión con la base de datos no ha podido finalizar correctamente.");
        }

        return affectedRows;
    }

    @Override
    public int update(Patient patient) {
        logger.info("Registrando el driver y conectando a la base de datos.");
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido establecer conexión con la base de datos.");
        }

        int affectedRows = 0;

        try{
            String query = "UPDATE pacientes SET nombre = ?, telefono = ?, grupo_sanguineo = ?, edad = ? WHERE dni = ?";
            PreparedStatement filter = conn.prepareStatement(query);
            filter.setString(1, patient.getName());
            filter.setString(2, patient.getPhoneNumber());
            filter.setString(3, patient.getBloodType().toString());
            filter.setInt(4, patient.getAge());
            filter.setString(5, patient.getDni());

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido guardar el nuevo paciente.");
        }

        logger.info("Desconectando de la base de datos");
        try {
            conn.close();
        } catch (SQLException ex) {
            logger.error("Error: la conexión con la base de datos no ha podido finalizar correctamente.");
        }
        return affectedRows;
    }

    @Override
    public int delete(String dni) {
        logger.info("Registrando el driver y conectando a la base de datos.");
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido establecer conexión con la base de datos.");
        }

        int affectedRows = 0;

        try {
            String query = "DELETE FROM pacientes WHERE dni = ?";
            PreparedStatement filter = conn.prepareStatement(query);
            filter.setString(1, dni);

            affectedRows = filter.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error: no se ha podido borrar el registro.");
        }

        return affectedRows;
    }
}
