import model.impl.Patient;
import org.apache.log4j.Logger;
import persistence.impl.DAOPatient;

import java.util.ArrayList;
import java.util.List;

//TODO create DAO implementations for each class
//TODO implement the CRUD operations for Patient

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        showAllPatients();
        showOnePatient("0");
    }

    public static void showAllPatients() {
        DAOPatient daoPatient = new DAOPatient();
        List<Patient> patients = new ArrayList<>();

        try{
            patients = daoPatient.getAll();
        } catch (NullPointerException ex) {
            logger.error("La lista no contiene pacientes.");
        }

        System.out.println("Todos los registros: ");
        patients.forEach(System.out::println);

    }

    public static void showOnePatient(String dni) {
        DAOPatient daoPatient = new DAOPatient();

        Patient patient = daoPatient.getByID(dni);
        if(patient != null) {
            System.out.println("Registro del paciente con el dni indicado:");
            System.out.println(patient);
        } else {
            System.out.println("No hay ningún paciente registrado con ese dni");
        }
    }

    public static void updatePatientData() {

    }

    public static void deletePatients() {

    }

}
