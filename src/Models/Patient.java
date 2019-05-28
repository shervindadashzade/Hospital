package Models;

public class Patient extends Person{
    String ill;
    Bed bed;
    Doctor doctor;
    public Patient(int nationalCode, String firstName, String lastName, int age,String ill){
        super(nationalCode,firstName,lastName,age);
        this.ill = ill;
    }

    @Override
    public String toString() {
        String str = String.format("%d %s %s %d $s %d",nationalCode,firstName,lastName,age,ill,doctor.nationalCode);
        return str;
    }
}
