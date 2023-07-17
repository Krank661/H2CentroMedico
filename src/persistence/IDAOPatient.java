package persistence;

import model.impl.Patient;

import java.util.List;

public interface IDAOPatient extends IDAO<Patient, String>{
    List<Patient> getByName(String name);
    List<Patient> getByPhoneNumber(String phoneNumber);
}
