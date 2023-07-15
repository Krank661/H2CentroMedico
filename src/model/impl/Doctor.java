package model.impl;

import enums.Specialties;
import model.MedicalProfessional;

import java.util.Objects;

public class Doctor extends MedicalProfessional {
    private Specialties specialty;

    public Doctor() {
        super();
    }

    public Doctor(String dni, String name, String phoneNumber, Integer id, Specialties specialty) {
        super(dni, name, phoneNumber, id);
        this.specialty = specialty;
    }

    public Specialties getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialties specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return getSpecialty() == doctor.getSpecialty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSpecialty());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialty=" + specialty +
                "} " + super.toString();
    }
}
