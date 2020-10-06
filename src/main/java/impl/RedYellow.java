package impl;

import trafficlight.model.state.TrafficLightState;

public class RedYellow extends TrafficLightState {
    public RedYellow() {
    }

    public boolean canGo() {
        return false;
    }

    public boolean shouldStop() {
        return true;
    }

    public void printState() {
        System.out.println("The light is RedYellow");
    }

    private static class Singleton {
        private static RedYellow INSTANCE = new RedYellow();


    }

    public static RedYellow getInstance() {
        return Singleton.INSTANCE;
    }
}
