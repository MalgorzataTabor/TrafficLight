package impl;

import trafficlight.model.state.TrafficLightState;

public class RedLight extends TrafficLightState {

    public RedLight() {
    }

    public boolean canGo() {
        return false;
    }

    public boolean shouldStop() {
        return true;
    }

    public void printState() {
        System.out.println("This is Red light ");
    }


    private static class Singleton {

        private static RedLight INSTANCE = new RedLight();
    }

    public static RedLight getInstance() {
        return Singleton.INSTANCE;
    }
}
