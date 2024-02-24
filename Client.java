package LLD.ParkingLot;

import LLD.ParkingLot.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client method");

        //Default Parking lot
        ParkingLot parkingLot = new ParkingLot("PR1234");
        parkingLot.addFloor(10, 5, 2);
        parkingLot.addFloor(5, 6, 3);

        List<String> tickets = new ArrayList<>();
        String baseVehicle = "truck";
        for (int i = 1; i <= 6; i++) {
            String vehicleId = baseVehicle + i;
            String ticketId = parkingLot.park(vehicleId, VehicleType.TRUCK);
            if (ticketId != null) {
                tickets.add(ticketId);
                System.out.println("Parked " + vehicleId + ", ticket id: " + ticketId);
            } else {
                System.out.println("No space available");
            }
        }

        for (int i = 1; i <= 6; i++) {
            String vehicleId = baseVehicle + i;
            boolean success = parkingLot.unPark(vehicleId);
            if (success) {
                System.out.println("Successfully unparked " + vehicleId);
            } else {
                System.out.println("vehicle not available");
            }
        }

    }
}
