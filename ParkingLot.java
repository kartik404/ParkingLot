package LLD.ParkingLot;

import LLD.ParkingLot.enums.VehicleType;
import LLD.ParkingLot.model.Floor;
import LLD.ParkingLot.model.ParkingSlot;
import LLD.ParkingLot.model.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<Floor> floors;
    public Map<String, Ticket> tickets;
    private String id;

    public ParkingLot(String id) {
        this.id = id;
        this.floors = new ArrayList<>();
        this.tickets = new HashMap<>();
        System.out.println("Parking lot " + id + " created");
    }

    public String getId() {
        return id;
    }

    public void addFloor(int numBikeSlots, int numCarSlots, int numTruckSlots) {
        List<ParkingSlot> slots = new ArrayList<>();

        List<ParkingSlot> bikeSlots = new ArrayList<>();
        for (int i = 0; i < numBikeSlots; i++) {
            bikeSlots.add(new ParkingSlot(VehicleType.BIKE));
        }
        slots.addAll(bikeSlots);

        List<ParkingSlot> carSlots = new ArrayList<>();
        for (int i = 0; i < numCarSlots; i++) {
            carSlots.add(new ParkingSlot(VehicleType.CAR));
        }
        slots.addAll(carSlots);

        List<ParkingSlot> truckSlots = new ArrayList<>();
        for (int i = 0; i < numTruckSlots; i++) {
            truckSlots.add(new ParkingSlot(VehicleType.TRUCK));
        }
        slots.addAll(truckSlots);

        Floor floor = new Floor(slots);
        floors.add(floor);
        System.out.println("New floor added with capacity to park " +
                                   numBikeSlots + " bikes, " +
                                   numCarSlots + " cars and " +
                                   numTruckSlots + " trucks");
    }

    public String park(String vehicleId, VehicleType vehicleType) {
        for (Floor floor: floors) {
            for (ParkingSlot slot: floor.getSlots()) {
                if (!slot.isReserved() && slot.getVehicleType() == vehicleType){
                    slot.setReserved(true);
                    Ticket ticket = new Ticket();
                    ticket.setVehicleId(vehicleId);
                    ticket.setSlot(slot);

                    this.tickets.put(vehicleId, ticket);
                    return vehicleId;
                }
            }
        }
        return null;
    }

    public boolean unPark(String vehicleId) {
        if (tickets.containsKey(vehicleId)) {
            Ticket ticket = tickets.get(vehicleId);
            ticket.getSlot().setReserved(false);
            tickets.remove(vehicleId);
            return true;
        }
        return false;
    }
}
