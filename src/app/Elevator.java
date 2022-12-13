package app;

public class Elevator
{
    // Variables
    private String name;
    private int currentFloor;
    private int floorMoves;

    public Elevator(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getFloorMoves() {
        return floorMoves;
    }

    public void addFloorMoves(int floorMoves) {
        this.floorMoves += floorMoves;
    }
}