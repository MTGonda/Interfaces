import java.io.File;

enum FlightStages implements Trackable{GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;

    @Override
    public void track() {
        if(this != GROUNDED){
            System.out.println("Monitoring" + this);
        }
    }
    public FlightStages getNextStage(){
        FlightStages[] allStages = values();
        return allStages[(ordinal() +1 )%allStages.length];
    }
}
record DragonFly(String name, String type) implements FlightEnabled{

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}
class Satellite implements OrbitEarth{
    FlightStages stage = FlightStages.GROUNDED;

    public void achiveOrbit(){
        System.out.println("Orbit achived");
    }

    @Override
    public void takeOff() {
transition("taking off");
    }

    @Override
    public void land() {
        transition("landing");
    }

    @Override
    public void fly() {
        achiveOrbit();
        transition("collecting data");
    }

    public void transition(String describtion){
        System.out.println(describtion);
        stage = transition(stage);
        stage.track();
    }
}
interface OrbitEarth extends FlightEnabled{
    void achiveOrbit();
    private static void log(String describtion){
        var today = new java.util.Date();
        System.out.println(today + ": " + describtion);
    }
    private void logStage(FlightStages stages, String describtion){
        describtion = stages + ": " + describtion;
        log(describtion);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage,"Begining Transition to " + nextStage);
        return nextStage;
    }
}

interface FlightEnabled{
    double MILES_TO_KM = 1.609;
    double KM_TO_MILES = 0.621;
    void takeOff();
    void land();
    void fly();

    default FlightStages transition(FlightStages stage){
//        System.out.println("transition not implemented on" + getClass().getName());
//        return null;
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning form " + stage + " to " + nextStage);
        return nextStage;

    }

}

interface Trackable{
    void track();
}
public abstract class Animal {

    public abstract void move();
}
