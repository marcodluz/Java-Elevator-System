package testing;

import app.ElevatorCall;

import java.util.List;

public class ElevatorCallTest {

    // Location of the file for test
    static String file = "src/db/CallList1.csv";

    public static void main(String[] args) {
        System.out.println("--- Starting ElevatorCall Test ---\n");

        testNextFileCall();

        System.out.println("\n---- Ending ElevatorCall Test ----");
    }

    public static void testNextFileCall() {

        ElevatorCall elevatorCall = new ElevatorCall(file);
        elevatorCall.getNextFileCall();
        System.out.println("Current floor: " + elevatorCall.getCurrentFloor());
        System.out.println("Direction: " + elevatorCall.getDirection());

        List<Integer> destinations = elevatorCall.getDestinations();

        for(int destination = 0; destination < elevatorCall.getDestinations().size(); destination++) {
            System.out.println("Destination #" + destination + ": " + destinations.get(destination));
        }
    }

}
