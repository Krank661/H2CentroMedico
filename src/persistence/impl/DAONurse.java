package persistence.impl;

import model.impl.Nurse;
import persistence.IDAO;

import java.util.List;

public class DAONurse implements IDAO<Nurse, Integer> {
    @Override
    public List<Nurse> getAll() {
        return null;
    }

    @Override
    public Nurse getByID(Integer id) {
        return null;
    }

    @Override
    public int create(Nurse nurse) {
        return 0;
    }

    @Override
    public int update(Nurse nurse) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
