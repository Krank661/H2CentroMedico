package persistence;

import enums.Specialties;
import model.impl.Doctor;

import java.util.List;

public interface IDAODoctor extends IDAO<Doctor, Integer>{
    List<Doctor> getBySpecialty(Specialties specialty);
}
