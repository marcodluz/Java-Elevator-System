package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleAlgorithm {

    // Variables
    private int time;
    private List<Integer> passengerTime = new ArrayList<Integer>();
    private int sum = 0;
    private int avg = 0;
    Elevator elevators[] = new Elevator[3];

    // Execute the algorithm
    public void start (String file) {

        // Start the lines reader
        ElevatorCall elevatorCall = new ElevatorCall(file);

        // Initialize each elevator
        elevators[0] = new Elevator("A");
        elevators[1] = new Elevator("B");
        elevators[2] = new Elevator("C");

        // Start the elevators at the ground floor
        elevators[0].setCurrentFloor(0);
        elevators[1].setCurrentFloor(0);
        elevators[2].setCurrentFloor(0);

        // Read through the 100 lines of the file
        for (int i = 0; i < 100;  i++) {
            elevatorCall.getNextFileCall();

            // Organize the destinations ascending
            Collections.sort(elevatorCall.getDestinations());

            // Get a random number from 0 to 2
            int random_int = (int)Math.floor(Math.random()*(2-0+1)+0);

            // Read all the destinations
            for (int j = 0; j < elevatorCall.getDestinations().size(); j++) {

                // Calculate the total time required
                time += (Math.abs(elevators[random_int].getCurrentFloor() - elevatorCall.getDestinations().get(j)) * 30) + 2*20;

                // Calculate the passenger journey time
                passengerTime.add((Math.abs(elevators[random_int].getCurrentFloor() - elevatorCall.getDestinations().get(j)) * 30) + 2*20);

                // Calculate the number of moves of the elevator
                elevators[random_int].setCurrentFloor(elevatorCall.getDestinations().get(j));
                elevators[random_int].addFloorMoves(1);

            }
        }

        // Read through all the passengers journeys times
        for(int i = 0; i < passengerTime.size(); i++) {

            // Sum all the passengers times
            sum = sum + passengerTime.get(i);

            // Calculate the average passenger journey times
            avg = sum / passengerTime.size();
        }

        // Insert into the log file
        LogWriter.add(
                "\n" +
                        "File: " + file + "\n" +
                        "Minimum journey time for a passenger: " + Collections.min(passengerTime) + "s \n" +
                        "Maximum journey time for a passenger: " + Collections.max(passengerTime) + "s \n" +
                        "Mean journey time for a passenger: " + avg + "s \n \n" +
                        "Elevator A moves: " + elevators[0].getFloorMoves() + "\n" +
                        "Elevator B moves: " + elevators[1].getFloorMoves() + "\n" +
                        "Elevator C moves: " + elevators[2].getFloorMoves() + "\n \n" +
                        "Total time required: " + time + "s");

    }
}
