package impl;

import org.w3c.dom.ls.LSOutput;
import trafficlight.model.state.TrafficLightState;

public class GreenLight extends TrafficLightState {
    public GreenLight() {
    }

    public boolean canGo() {
        return true;
    }

    public boolean shouldStop() {
        return false;
    }

    public void printState() {
        System.out.println("This is Green Light ");

    }

    private static class Singleton{
        private static GreenLight INSTANCE= new GreenLight();

    }

    public static GreenLight getInstance(){
        return Singleton.INSTANCE;

    }
}
