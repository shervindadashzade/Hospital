package Test;

import Controller.FileHandler;
import Models.Bed;
import Models.Room;
import Models.Stair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String args[]){
        Stair stair1 = new Stair(1);
        Stair stair2 = new Stair(2);
        Room room101 = new Room(101);
        stair1.addRoom(room101);
        Room room201 = new Room(201);
        stair2.addRoom(room201);
        Bed bed1 = new Bed(1);
        room101.addBed(bed1);
        Bed bed2 = new Bed(2);
        room201.addBed(bed2);

        FileHandler.writeObject(stair1);
        FileHandler.writeObject(stair2);
        FileHandler.writeObject(room101);
        FileHandler.writeObject(room201);
        FileHandler.writeObject(bed1);
        FileHandler.writeObject(bed2);
    }
}
