import enums.BloodTypes;
import model.impl.Patient;
import org.apache.log4j.Logger;
import persistence.impl.DAOPatient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TODO create DAO implementations for each class
//TODO implement the CRUD operations for Patient
//TODO fffffffffffffffffffffuuuuuuuuuuuuuuuuuuuucccccccccccccccckkkkkkkkkkkkkkkkk

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);
    static DAOPatient daoPatient;


    public static void main(String[] args) {
        showAllPatients();
    }

    public static void showAllPatients() {
        List<Patient> patients = new ArrayList<>();

        try{
            patients = daoPatient.getAll();
        } catch (NullPointerException ex) {
            logger.error("La lista no contiene pacientes.");
        }

        System.out.println("Todos los registros: ");
        patients.forEach(System.out::println);

    }

    public static void updatePatientData() {

    }

    public static void deletePatients() {

    }

}
