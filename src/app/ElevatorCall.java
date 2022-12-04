package app;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCall
{
    public static int id = 0;
    private int currentFloor;
    private int direction;
    private List<Integer> destinations = new ArrayList<>();
    private String file;

    public ElevatorCall(String file) {
        this.file = file;
    }

    public void getNextFileCall() {

        destinations.clear();

        FileReaderCSV fileReaderCSV = new FileReaderCSV(file);
        fileReaderCSV.readFile();

        int lineSize = fileReaderCSV.lines.get(id).size();
        String next;
        int idDestinations = 0;

        System.out.println("Call ID #" + id);

        for(int i = 0; i < lineSize; i++) {
            if(i == 0) {
                next = fileReaderCSV.lines.get(id).get(0);

                if(next == "NOCALL") {
                    break;
                }

                currentFloor = Integer.parseInt(next);

            } else if (i == 1) {
                next = fileReaderCSV.lines.get(id).get(1);
                if (next.equals("DOWN")) {
                    direction = 0;
                } else if (next.equals("UP")) {
                    direction = 1;
                }

            } else {

                next = fileReaderCSV.lines.get(id).get(i);
                destinations.add(Integer.parseInt(next));

                //System.out.println("Destination #" + idDestinations + ": " + next);
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
