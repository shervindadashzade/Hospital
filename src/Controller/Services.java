package Controller;

import Models.*;

import javax.print.Doc;
import java.io.File;

public class Services {

   public static void createStair(int num){
       Stair stair = new Stair(num);
       FileHandler.writeObject(stair);
       FileHandler.stairs.add(stair);
   }
   public static void createRoom(int num,Stair stair){
       Room room = new Room(num);
       stair.addRoom(room);
       FileHandler.writeObject(room);
       FileHandler.rooms.add(room);
   }
   public static void createBed(int num,Room room){
       Bed bed = new Bed(num);
       room.addBed(bed);
       FileHandler.writeObject(bed);
       FileHandler.beds.add(bed);
   }
    public static void signupDoctor(int nationalCode, String firstName, String lastName, int age,String explicit) {
       Doctor doctor = new Doctor(nationalCode,firstName,lastName,age,explicit);
       FileHandler.writeObject(doctor);
       FileHandler.doctors.add(doctor);
   }
   public static void signupNurse(int nationalCode, String firstName, String lastName, int age){
       Nurse nurse = new Nurse(nationalCode,firstName,lastName,age);
       FileHandler.writeObject(nurse);
       FileHandler.nurses.add(nurse);
   }
   public static void signupPatient(int nationalCode, String firstName, String lastName, int age, String ill, Doctor doctor,Bed bed){
       Patient patient = new Patient(nationalCode,firstName,lastName,age,ill);
       doctor.addPatient(patient);
       if(bed.isEmpty())
           bed.setPatient(patient);
       else{
           System.out.println("Bed isnt Empty please select another");
           return;
       }
       FileHandler.writeObject(patient);
       FileHandler.patients.add(patient);
   }
}
