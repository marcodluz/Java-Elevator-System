package app;

import java.util.Arrays;

public class ElevatorCall
{
    private String currentFloor;
    private String direction;
    private String destination;

    public ElevatorCall(String currentFloor, String direction, String destination) {
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "ElevatorCall{" +
                "currentFloor=" + currentFloor +
                ", direction='" + direction + '\'' +
                ", destination=" + destination +
                '}';
    }
}
