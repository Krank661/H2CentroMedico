package model.impl;

import enums.BloodTypes;
import model.IPatient;
import model.Person;

import java.util.Objects;

public class Patient extends Person implements IPatient {
    private int age;
    private BloodTypes bloodType;

    public Patient() {
        super();
    }

    public Patient(String dni, String name, String phoneNumber, int age, BloodTypes bloodType) {
        super(dni, name, phoneNumber);
        this.age = age;
        this.bloodType = bloodType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BloodTypes getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodTypes bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return getAge() == patient.getAge() && getBloodType() == patient.getBloodType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAge(), getBloodType());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", bloodType=" + bloodType +
                "} " + super.toString();
    }
}
