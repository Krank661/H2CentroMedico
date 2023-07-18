import enums.BloodTypes;
import enums.Specialties;
import model.impl.Doctor;
import model.impl.Patient;
import org.apache.log4j.Logger;
import persistence.impl.DAODoctor;
import persistence.impl.DAOPatient;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //TODO implement the queries of v2

    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //patientTests();
        doctorTests();
    }

    public static void showAllPatients() {
        DAOPatient daoPatient = new DAOPatient();
        List<Patient> patients = new ArrayList<>();

        try{
            patients = daoPatient.getAll();
        } catch (NullPointerException ex) {
            logger.error("La lista no contiene pacientes.");
        }

        System.out.println("Todos los registros de pacientes: ");
        patients.forEach(System.out::println);

    }

    public static void showOnePatientById(String dni) {
        DAOPatient daoPatient = new DAOPatient();

        Patient patient = daoPatient.getByID(dni);
        if(patient != null) {
            System.out.println("Registro del paciente con el dni indicado:");
            System.out.println(patient);
        } else {
            System.out.println("No hay ningún paciente registrado con ese dni");
        }
    }

    public static void showPatientsByName(String name) {
        DAOPatient daoPatient = new DAOPatient();
        List<Patient> patients = new ArrayList<>();

        try{
            patients = daoPatient.getByName(name);
        } catch (NullPointerException ex) {
            logger.error("La lista no contiene pacientes.");
        }

        System.out.println("Registros de los pacientes con el nombre indicado: ");
        patients.forEach(System.out::println);
    }

    public static void showPatientsByPhoneNumber(String phoneNumber) {
        DAOPatient daoPatient = new DAOPatient();
        List<Patient> patients = new ArrayList<>();

        try{
            patients = daoPatient.getByPhoneNumber(phoneNumber);
        } catch (NullPointerException ex) {
            logger.error("La lista no contiene pacientes.");
        }

        System.out.println("Registros de los pacientes con el número de teléfono indicado: ");
        patients.forEach(System.out::println);
    }

    public static void insertAPatient(Patient patient) {
        DAOPatient daoPatient = new DAOPatient();

        int affectedRows = daoPatient.create(patient);
        System.out.println("Registros afectados en el insert: " + affectedRows);
    }

    public static void updatePatientData(Patient patient) {
        DAOPatient daoPatient = new DAOPatient();
        //patient.setName("");
        patient.setPhoneNumber("76543166");
        //patient.setBloodType(BloodTypes.APOS);
        patient.setAge(33);

        int affectedRows = daoPatient.update(patient);
        System.out.println("Registros afectados en el update: " + affectedRows);
    }

    public static void deletePatients(Patient patient) {
        DAOPatient daoPatient = new DAOPatient();

        int affectedRows = daoPatient.delete(patient.getDni());
        System.out.println("Registros afectados en el delete: " + affectedRows);
    }

    public static void patientTests() {
        showAllPatients();
        showOnePatientById("42512851L");
        Patient patient = new Patient("16992267M", "Carlos", "76543123", 32, BloodTypes.ABPOS);
        insertAPatient(patient);
        showAllPatients();
        updatePatientData(patient);
        showAllPatients();
        showPatientsByName("Carlos");
        showPatientsByPhoneNumber("123456");
        deletePatients(patient);
        showAllPatients();
    }

    public static void showAllDoctors() {
        DAODoctor daoDoctor = new DAODoctor();
        List<Doctor> doctors = new ArrayList<>();

        try{
            doctors = daoDoctor.getAll();
        } catch (NullPointerException ex) {
            logger.error("La lista no contiene médicos");
        }

        System.out.println("Todos los registros de médicos: ");
        doctors.forEach(System.out::println);
    }

    public static void showOneDoctorById(Integer id) {
        DAODoctor daoDoctor = new DAODoctor();

        Doctor doctor = daoDoctor.getByID(id);

        if(doctor != null) {
            System.out.println("Registro del médico con el id indicado: ");
            System.out.println(doctor);
        } else {
            System.out.println("No hay ningún médico registrado con ese dni.");
        }
    }

    public static void showDoctorsBySpecialty(Specialties specialty) {
        DAODoctor daoDoctor = new DAODoctor();
        List<Doctor> doctors = new ArrayList<>();

        try {
            doctors = daoDoctor.getBySpecialty(specialty);
        } catch (NullPointerException ex) {
            logger.error("La lista no contiene médicos.");
        }

        System.out.println("Registros de los médicos de la especialidad indicada: ");
        doctors.forEach(System.out::println);
    }

    public static void insertADoctor(Doctor doctor) {
        DAODoctor daoDoctor = new DAODoctor();

        int affectedRows = daoDoctor.create(doctor);
        System.out.println("Registros afectados en el insert: " + affectedRows);
    }

    public static void doctorTests() {
        //showAllDoctors();
        //showOneDoctorById(1);
        //showDoctorsBySpecialty(Specialties.GENERAL_PRACTICIONER);
        Doctor doctor = new Doctor("64747065H", "Tenma", "999999", 4, Specialties.PEDIATRIST);
        //insertADoctor(doctor);
        //showAllDoctors();
    }

}
