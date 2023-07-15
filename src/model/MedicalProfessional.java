package model;

import java.util.Objects;

public abstract class MedicalProfessional extends Person implements IMedicalProfessional{

    private Integer id;

    public MedicalProfessional() {
        super();
    }

    public MedicalProfessional(String dni, String name, String phoneNumber, Integer id) {
        super(dni, name, phoneNumber);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalProfessional)) return false;
        if (!super.equals(o)) return false;
        MedicalProfessional that = (MedicalProfessional) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "model.MedicalProfessional{" +
                "id=" + id +
                "} " + super.toString();
    }
}
