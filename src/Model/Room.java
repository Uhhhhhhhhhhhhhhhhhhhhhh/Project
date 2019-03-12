/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.util.Comparator.comparing;

/**
 *
 * @author Derek
 */
public class Room implements Comparable<Room> {
    
    private String building;
    private String room_id;
    private int occupancy;
    private int computers;
    private String lab_type;

    public Room(String building, String room_id, int occupancy, int computers, String lab_type) {
        this.building = building;
        this.room_id = room_id;
        this.occupancy = occupancy;
        this.computers = computers;
        this.lab_type = lab_type;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public int getComputers() {
        return computers;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }

    public String getLab_type() {
        return lab_type;
    }

    public void setLab_type(String lab_type) {
        this.lab_type = lab_type;
    }

    @Override
    public String toString() {
        return "Room{" + "building=" + building + ", room_id=" + room_id + ", occupancy=" + occupancy + ", computers=" + computers + ", lab_type=" + lab_type + '}';
    }
    
    public String toEventString() {
        return building + " " + room_id;
    }
    
    @Override
    public int compareTo(Room other) {
        return comparing(Room::getBuilding)
                .thenComparing(Room::getRoom_id)
                .compare(this, other);
    }
    
}
