package impl;

import trafficlight.model.state.TrafficLightState;

public class FlashingLightGreen extends TrafficLightState {

    public FlashingLightGreen() {
    }


    public boolean canGo() {
        return false;
    }

    public boolean shouldStop() {
        return false;
    }


    public void printState() {
        System.out.println(" the light is Flashing Light Green");

    }

    private static class Singleton {
        private static FlashingLightGreen INSTANCE = new FlashingLightGreen();
    }

    public static FlashingLightGreen getInstance() {
        return Singleton.INSTANCE;
    }
}
