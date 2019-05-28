package Models;

import java.util.ArrayList;

public class Stair {
    private int numStair;
    private ArrayList<Room> rooms = new ArrayList<>();

    public Stair(int numStair){
        this.numStair = numStair;
    }
    public void addRoom(Room room){
        rooms.add(room);
        room.stair = this;
    }

    public int getNumStair() {
        return numStair;
    }

    @Override
    public String toString() {
        String str = String.format("%d",numStair);
        return str;
    }
}
