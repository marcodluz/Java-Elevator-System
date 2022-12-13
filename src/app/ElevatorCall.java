package app;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCall
{
    // Variables
    private int id;
    private int currentFloor;
    private int direction;
    private List<Integer> destinations = new ArrayList<>();
    private String file;
    private int lineSize = 0;

    public ElevatorCall(String file) {
        this.file = file;
    }

    // Method to get each line of the CSV file
    public void getNextFileCall() {

        // Clear the destinations array list
        destinations.clear();

        // Read the file
        FileReaderCSV fileReaderCSV = new FileReaderCSV(file);
        fileReaderCSV.readFile();

        // Get the number of lines from the file
        lineSize = fileReaderCSV.lines.get(id).size();
        String next;

        // Read through all lines
        for(int i = 0; i < lineSize; i++) {

            // First item of a line is the current floor
            if(i == 0) {
                next = fileReaderCSV.lines.get(id).get(0);

                // Read the NOCALL lines as 7
                if(next.equals("NOCALL")) {
                    currentFloor = 7;
                    break;
                }

                currentFloor = Integer.parseInt(next);

            // The second item of a line is the direction
            } else if (i == 1) {
                next = fileReaderCSV.lines.get(id).get(1);
                // Read the DOWN call as 0
                if (next.equals("DOWN")) {
                    direction = 0;

                // Read the UP call as 1
                } else if (next.equals("UP")) {
                    direction = 1;
                }

            // The last part of a line are the destinations
            } else {
                next = fileReaderCSV.lines.get(id).get(i);
                destinations.add(Integer.parseInt(next));
            }
        }

        id += 1;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDirection() {
        return direction;
    }

    public List<Integer> getDestinations() {
        return destinations;
    }

    @Override
    public String toString() {
        return "ElevatorCall{" +
                "currentFloor=" + currentFloor +
                ", direction='" + direction + '\'' +
                ", destination=" + destinations +
                '}';
    }
}
