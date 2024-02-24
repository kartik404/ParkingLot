It is a very basic parking lot implementation.

There can be many improvements:
1. ParkingSlot can be an interface/abstract class and bike, car, truck slot can implement/extend it.
2. Use ParkingStrategy in ParkingLot to make it more versatile.
---
#### Design patterns that can be used:
- Singleton - to get a single instance of parking lot
- Strategy - to create a pricing strategy
- Factory - to get instances

#### Components:
- Parking spot types
- Parking spots
- Parking floors
- Parking ticket
- Parking lot
- Pricing strategy
- Parking entry/exit