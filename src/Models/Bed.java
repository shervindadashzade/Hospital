package Models;

public class Bed {
    public int numberOfBed;
    Room room;
    Patient patient;

    public Bed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
        patient.bed = this;
    }

    @Override
    public String toString() {
        String str = String.format("%d %d",numberOfBed,room.numberOfRoom);
        return str;
    }
    public boolean isEmpty(){
        if(patient == null)
            return true;
        return false;
    }
}
