package impl;

import trafficlight.model.state.TrafficLightState;

public class YellowLight extends TrafficLightState {
    public boolean canGo() {
        return true;
    }

    public boolean shouldStop() {
        return false;
    }

    public void printState() {
        System.out.println("This is YellowLight");
    }

    public YellowLight() {
    }

    private static class Singleton {
        private static YellowLight INSTANCE = new YellowLight();
    }

    public static YellowLight getInstance() {
        return Singleton.INSTANCE;
    }
}
