package trafficlight.model.state;

import impl.*;


public enum LightStateDescription implements TranspositionInterface {

    RED_TO_REDYELLOW(RedLight.getInstance(), RedYellow.getInstance()),
    REDYELLOW_TO_GREEN(RedYellow.getInstance(), GreenLight.getInstance()),
    YELLOW_TO_RED(YellowLight.getInstance(), RedLight.getInstance()),
    GREEN_TO_YELLOW(GreenLight.getInstance(), YellowLight.getInstance());


    private TrafficLightState actually;
    private TrafficLightState next;


    LightStateDescription(TrafficLightState actually, TrafficLightState next) {
        this.actually = actually;
        this.next = next;
    }

    @Override
    public TrafficLightState getActual() {
        return actually;
    }

    @Override
    public TrafficLightState getNext() {
        return next;
    }

    public TranspositionInterface getTranspositionFor(TrafficLightState now) {

        LightStateDescription[] values = values();

        for (int i = 0; i < values.length; i++) {
            LightStateDescription value = values[i];

            if (value.actually.equals(now)) {
                return value;
            }
        }
        return null;
    }
}
