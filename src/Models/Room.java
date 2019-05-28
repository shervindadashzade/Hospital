package Models;

import java.util.ArrayList;

public class Room {
    public int numberOfRoom;
    Stair stair;
    public int maxBed=5;
    int c=0;
    ArrayList<Bed> beds = new ArrayList<>();

    public Room(int numberOfRoom){
        this.numberOfRoom = numberOfRoom;
    }

    public void addBed(Bed bed){
        if(c<maxBed) {
            beds.add(bed);
            bed.room = this;
            c++;
        }else {
            System.out.println("cant add bed");
        }
    }

    @Override
    public String toString() {
        String str = String.format("%d %d",numberOfRoom,stair.getNumStair());
        return str;
    }
}
