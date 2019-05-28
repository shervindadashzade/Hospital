package Models;

import java.util.ArrayList;

public class Doctor extends Person{
    String explicit;
    ArrayList<Patient> patients = new ArrayList<>();
    public Doctor(int nationalCode, String firstName, String lastName, int age,String explicit){
        super(nationalCode,firstName,lastName,age);
        this.explicit = explicit;
    }
    public void addPatient(Patient p){
        patients.add(p);
        p.doctor = this;
    }

    @Override
    public String toString() {
        String str = String.format("%d %s %s %d $s",nationalCode,firstName,lastName,age,explicit);
        return str;
    }
}
