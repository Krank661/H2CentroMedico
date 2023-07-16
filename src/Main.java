import enums.BloodTypes;
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
        showOnePatient("666");
        insertAPatient();
        showAllPatients();
        updatePatientData();
        showAllPatients();
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

    public static void insertAPatient() {
        DAOPatient daoPatient = new DAOPatient();
        Patient patient = new Patient("222", "Carlos", "76543123", 32, BloodTypes.ABPOS);

        int affectedRows = daoPatient.create(patient);
        System.out.println("Registros afectados en el insert: " + affectedRows);
    }

    public static void updatePatientData() {
        DAOPatient daoPatient = new DAOPatient();
        Patient patient = new Patient("222", "Carlos", "76543166", 33, BloodTypes.ABPOS);

        int affectedRows = daoPatient.update(patient);
        System.out.println("Registros afectados en el update: " + affectedRows);
    }

    public static void deletePatients() {

    }

}
