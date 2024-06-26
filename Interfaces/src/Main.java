import jdk.jfr.Enabled;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        Trackable trackable = bird;
        FlightEnabled flightEnabled = bird;

        animal.move();
//        trackable.move();
//        flightEnabled.move();
//        flightEnabled.takeOff();
//        flightEnabled.fly();
//        trackable.track();
//        flightEnabled.land();
        inFlight(flightEnabled);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n",kmsTraveled,milesTraveled);
        LinkedList<FlightEnabled> flightEnableds = new LinkedList<>();
        flightEnableds.add(bird);

        List<FlightEnabled> flightEnabledList = new LinkedList<>();
        flightEnabledList.add(bird);

        triggerFliers(flightEnableds);
        flyFliers(flightEnableds);
        landFliers(flightEnableds);

        triggerFliers(flightEnabledList);
        flyFliers(flightEnabledList);
        landFliers(flightEnabledList);
    }

    private static void inFlight(FlightEnabled flightEnabled){
        flightEnabled.takeOff();
        flightEnabled.fly();
        if(flightEnabled instanceof  Trackable trackable){
            trackable.track();
        }
        flightEnabled.land();
    }

    private static void triggerFliers(List<FlightEnabled> fliers){
        for (var flier:fliers){
            flier.takeOff();

        }
    }

    private static void flyFliers(List<FlightEnabled> fliers){
        for (var flier:fliers){
            flier.fly();

        }
    }
    private static void landFliers(List<FlightEnabled> fliers){
        for (var flier:fliers){
            flier.land();

        }
    }
}