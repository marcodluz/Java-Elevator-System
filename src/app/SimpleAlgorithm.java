package app;

public class SimpleAlgorithm {

    // Location of the file for test
    static String file1 = "src/db/CallList1.csv";

    public void start () {
        //Initialize the Elevators
        Elevator elevatorA = new Elevator("A");
        Elevator elevatorB = new Elevator("B");
        Elevator elevatorC = new Elevator("C");

        //Initialize the calls for file 1
        ElevatorCall elevatorCall = new ElevatorCall(file1);

        elevatorCall.getNextFileCall();
        System.out.println("Current Floor: " + elevatorCall.getCurrentFloor());
        System.out.println("Direction: " + elevatorCall.getDirection());
        System.out.println("Destinations: " + elevatorCall.getDestinations());

        System.out.println("");

        elevatorCall.getNextFileCall();
        System.out.println("Current Floor: " + elevatorCall.getCurrentFloor());
        System.out.println("Direction: " + elevatorCall.getDirection());
        System.out.println("Destinations: " + elevatorCall.getDestinations());
    }
}
