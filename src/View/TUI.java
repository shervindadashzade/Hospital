package View;

import Controller.FileHandler;
import Controller.Services;
import Models.*;

import java.io.File;
import java.util.Scanner;
//fast tui only for test
public class TUI {
    public static void main(String[] args){
        try {
            System.out.println("Enter password for managment:");
            Scanner sc = new Scanner(System.in);
            String pass = sc.nextLine();
            if (pass.equals("1349")) {
                FileHandler.loadSavedStructure();
                int commands = 0;
                while (commands != 11) {
                    System.out.println("1-create a stair");
                    System.out.println("2-create a room");
                    System.out.println("3-create a bed");
                    System.out.println("4-signup a nurse");
                    System.out.println("5-signup a doctor");
                    System.out.println("6-signup a patient");
                    System.out.println("7-report of bulding structer");
                    System.out.println("8-report of nurses");
                    System.out.println("9-report of doctors");
                    System.out.println("10-report of nurses/doctors");
                    System.out.println("11-exit");
                    commands = sc.nextInt();
                    switch (commands) {
                        case 1:
                            System.out.println("stair number:");
                            int stairNum = sc.nextInt();
                            Services.createStair(stairNum);
                            break;
                        case 2:
                            System.out.println("room number:");
                            int roomNum = sc.nextInt();
                            System.out.println("stair number:");
                            stairNum = sc.nextInt();
                            Stair stair = FileHandler.getStairOfNumber(stairNum);
                            if (stair != null)
                                Services.createRoom(roomNum, stair);
                            break;
                        case 3:
                            System.out.println("enter bed number:");
                            int bedNum = sc.nextInt();
                            System.out.println("enter room number:");
                            roomNum = sc.nextInt();
                            Room room = FileHandler.getRoomOfNumber(roomNum);
                            if (room != null)
                                Services.createBed(bedNum, room);
                            break;
                        case 4:
                            System.out.println("enter national code :");
                            int nationalcode = sc.nextInt();
                            System.out.println("enter firstname :");
                            sc.nextLine();
                            String firstname = sc.nextLine();
                            System.out.println("enter lastname :");
                            String lastname = sc.nextLine();
                            System.out.println("enter age:");
                            int age = sc.nextInt();
                            Services.signupNurse(nationalcode, firstname, lastname, age);
                            break;
                        case 5:
                            System.out.println("enter national code :");
                            nationalcode = sc.nextInt();
                            System.out.println("enter firstname :");
                            sc.nextLine();
                            firstname = sc.nextLine();
                            System.out.println("enter lastname :");
                            lastname = sc.nextLine();
                            System.out.println("enter age:");
                            age = sc.nextInt();
                            System.out.println("enter explicit :");
                            String explicit = sc.nextLine();
                            Services.signupDoctor(nationalcode, firstname, lastname, age, explicit);
                            break;
                        case 6:
                            System.out.println("enter national code :");
                            nationalcode = sc.nextInt();
                            System.out.println("enter firstname :");
                            sc.nextLine();
                            firstname = sc.nextLine();
                            System.out.println("enter lastname :");
                            lastname = sc.nextLine();
                            System.out.println("enter age:");
                            age = sc.nextInt();
                            System.out.println("enter ill :");
                            String ill = sc.nextLine();
                            System.out.println("enter doctor nationalcode :");
                            int doctorNationalCode = sc.nextInt();
                            System.out.println("enter bed number :");
                            bedNum = sc.nextInt();
                            Doctor doctor = FileHandler.getDoctorOfNationalCode(doctorNationalCode);
                            Bed bed = FileHandler.getBedOfNumber(bedNum);
                            if (doctor != null) {
                                if (bed != null) {
                                    Services.signupPatient(nationalcode, firstname, lastname, age, ill, doctor, bed);
                                }
                            }
                            break;
                        case 7:
                            //todo::crate tree view
                            System.out.println("Stair:");
                            for(Stair stair1: FileHandler.stairs)
                                System.out.println(stair1);
                            System.out.println("Rooms:");
                            for(Room room1:FileHandler.rooms)
                                System.out.println(room1);
                            System.out.println("Beds:");
                            for(Bed bed1:FileHandler.beds)
                                System.out.println(bed1);
                            break;
                        case 8:
                            for (Nurse nurse : FileHandler.nurses) {
                                System.out.println(nurse.toString());
                            }
                            break;
                        case 9:
                            for (Doctor doc : FileHandler.doctors) {
                                System.out.println(doc.toString());
                            }
                            break;
                        case 10:
                            for (Doctor doc : FileHandler.doctors) {
                                System.out.println(doc.toString());
                            }
                            for (Nurse nurse : FileHandler.nurses) {
                                System.out.println(nurse.toString());
                            }
                            break;
                    }
                }
            } else {
                System.out.println("Wrong pass");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
