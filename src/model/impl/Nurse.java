package model.impl;

import model.MedicalProfessional;

public class Nurse extends MedicalProfessional {
    public Nurse() {
        super();
    }

    public Nurse(String dni, String name, String phoneNumber, Integer id) {
        super(dni, name, phoneNumber, id);
    }

    @Override
    public String toString() {
        return "Nurse{} " + super.toString();
    }
}
