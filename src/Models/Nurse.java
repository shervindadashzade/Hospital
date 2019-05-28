package Models;

public class Nurse extends Person {
    public Nurse(int nationalCode, String firstName, String lastName, int age) {
        super(nationalCode,firstName,lastName,age);
    }

    @Override
    public String toString() {
        String str = String.format("%d %s %s %d",nationalCode,firstName,lastName,age);
        return str;
    }
}
