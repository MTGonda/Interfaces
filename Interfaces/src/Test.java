public class Test {
    public static void main(String[] args) {
        inFlight(new Jet());
    //    OrbitEarth.log("testoing" + new Satellite());
        orbit(new Satellite());
    }
    private static void inFlight(FlightEnabled flightEnabled){
        flightEnabled.takeOff();
        flightEnabled.transition(FlightStages.LAUNCH);
        flightEnabled.fly();
        if(flightEnabled instanceof  Trackable trackable){
            trackable.track();
        }
        flightEnabled.land();
    }

    private static void orbit(OrbitEarth flightEnabled){
        flightEnabled.takeOff();
        flightEnabled.fly();
        flightEnabled.land();
    }
}
