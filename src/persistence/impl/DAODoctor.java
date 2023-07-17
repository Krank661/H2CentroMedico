package persistence.impl;

import model.impl.Doctor;
import persistence.IDAO;

import java.util.List;

public class DAODoctor implements IDAO<Doctor, Integer> {
    @Override
    public List<Doctor> getAll() {
        return null;
    }

    @Override
    public Doctor getByID(Integer id) {
        return null;
    }

    @Override
    public int create(Doctor doctor) {
        return 0;
    }

    @Override
    public int update(Doctor doctor) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
