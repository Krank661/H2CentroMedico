package persistence.impl;

import model.impl.Paramedic;
import persistence.IDAO;

import java.util.List;

public class DAOParamedic implements IDAO<Paramedic, Integer> {
    @Override
    public List<Paramedic> getAll() {
        return null;
    }

    @Override
    public Paramedic getByID(Integer id) {
        return null;
    }

    @Override
    public int create(Paramedic paramedic) {
        return 0;
    }

    @Override
    public int update(Paramedic paramedic) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
