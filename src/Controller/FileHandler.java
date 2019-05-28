package Controller;

import Models.*;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static ArrayList<Stair> stairs = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Bed> beds = new ArrayList<>();
    public static ArrayList<Nurse> nurses = new ArrayList<>();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static boolean writeObject(Object obj){
        String filename = "?.txt";
        if(obj instanceof Bed)
            filename = "Assets/Database/bed/"+((Bed)obj).numberOfBed;
        if(obj instanceof Room)
            filename = "Assets/Database/room/"+((Room)obj).numberOfRoom;
        if(obj instanceof Stair)
            filename = "Assets/Database/stair/"+((Stair)obj).getNumStair();
        if(obj instanceof Nurse)
            filename = "Assets/Database/nurse/"+((Nurse)obj).getNationalCode();
        if(obj instanceof Doctor)
            filename = "Assets/Database/doctor/"+((Doctor)obj).getNationalCode();
        if(obj instanceof Patient)
            filename = "Assets/Database/patient/"+((Doctor)obj).getNationalCode();
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.append(obj.toString());
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void loadSavedStructure() throws IOException {
      File files = new File("Assets/Database/stair");
      if(files.listFiles() == null)
          return;
      for(File file:files.listFiles()){
          BufferedReader fileReader = new BufferedReader(new FileReader(file));
          String line = fileReader.readLine();
          Stair stair = new Stair(Integer.valueOf(line));
          stairs.add(stair);
          System.out.println(stair);
      }
      files = new File("Assets/Database/room");
      if(files.listFiles() == null)
          return;
      for(File file:files.listFiles()){
          BufferedReader fileReader = new BufferedReader(new FileReader(file));
          String line = fileReader.readLine();
          String info[] = line.split(" ");
          Room room = new Room(Integer.valueOf(info[0]));
          Stair stair = getStairOfNumber(Integer.valueOf(info[1]));
          if(stair != null)
              stair.addRoom(room);
          System.out.println(line);
          System.out.println(room);
          rooms.add(room);
      }

        files = new File("Assets/Database/bed");
        if(files.listFiles() == null)
            return;
        for(File file:files.listFiles()){
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line = fileReader.readLine();
            String info[] = line.split(" ");
            Bed bed = new Bed(Integer.valueOf(info[0]));
            Room room = getRoomOfNumber(Integer.valueOf(info[1]));
            if(room != null)
                room.addBed(bed);
            System.out.println(line);
            System.out.println(bed);
            beds.add(bed);
        }
        files = new File("Assets/Database/nurse");
        if(files.listFiles()== null )
            return;
        for(File file:files.listFiles()){
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line =fileReader.readLine();
            String[] info = line.split(" ");
            Nurse nurse = new Nurse(Integer.valueOf(info[0]),info[1],info[2],Integer.valueOf(info[3]));
            nurses.add(nurse);
        }
        files = new File("Assets/Database/doctor");
        if(files.listFiles()== null)
            return;
        for(File file:files.listFiles()){
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line =fileReader.readLine();
            String info[] = line.split(" ");
            Doctor doctor = new Doctor(Integer.valueOf(info[0]),info[1],info[2],Integer.valueOf(info[3]),info[4]);
            doctors.add(doctor);
        }
        files = new File("Assets/Database/patient");
        if(files.listFiles()== null)
            return;
        for(File file:files.listFiles()) {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line = fileReader.readLine();
            String info[] = line.split(" ");
            Doctor doctor = getDoctorOfNationalCode(Integer.valueOf(info[5]));
            Patient patient = new Patient(Integer.valueOf(info[0]),info[1],info[2],Integer.valueOf(info[3]),info[4]);
            doctor.addPatient(patient);
            patients.add(patient);
        }

        }


    public static Stair getStairOfNumber(int num){
        for(Stair stair : stairs){
            if(stair.getNumStair() == num)
                return stair;
        }
        System.out.println("No stair founded with num:"+num);
        return null;
    }

    public static Room getRoomOfNumber(int num){
        for(Room room : rooms){
            if(room.numberOfRoom == num)
                return room;
        }
        System.out.println("No room founded with num:"+num);
        return null;
    }
    public static Doctor getDoctorOfNationalCode(int num){
        for(Doctor doctor : doctors){
            if(doctor.getNationalCode() == num)
                return doctor;
        }
        System.out.println("No doctor founded with nationalcode:"+num);
        return null;
    }
    public static void DeleteObj(Object obj){
        if(obj instanceof Bed){
            beds.remove(obj);
            File file = new File("Assets/Database/bed/"+((Bed)obj).numberOfBed);
            file.delete();
        }
        if(obj instanceof Room){
            rooms.remove(obj);
            File file = new File("Assets/Database/room/"+((Room)obj).numberOfRoom);
            file.delete();
        }
        if(obj instanceof Stair){
            stairs.remove(obj);
            File file = new File("Assets/Database/stair/"+((Stair)obj).getNumStair());
            file.delete();
        }
        if(obj instanceof Nurse){
            nurses.remove(obj);
            File file = new File("Assets/Database/nurse/"+((Nurse)obj).getNationalCode());
            file.delete();
        }
        if(obj instanceof Doctor){
            doctors.remove(obj);
            File file = new File("Assets/Database/doctor/"+((Doctor)obj).getNationalCode());
            file.delete();
        }
        if(obj instanceof Patient){
            patients.remove(obj);
            File file = new File("Assets/Database/patient/"+((Patient)obj).getNationalCode());
            file.delete();
        }
    }
    public static Bed getBedOfNumber(int num){
        for(Bed bed:beds){
            if(bed.numberOfBed == num)
                return bed;
        }
        System.out.println("bed not founded with this number");
        return null;
    }
}
