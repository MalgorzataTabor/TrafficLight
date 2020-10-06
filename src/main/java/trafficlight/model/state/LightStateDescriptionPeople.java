package trafficlight.model.state;

import impl.FlashingLightGreen;
import impl.GreenLight;
import impl.RedLight;
import impl.TranspositionInterface;

public enum LightStateDescriptionPeople implements TranspositionInterface {

    RED_TO_GREEN(RedLight.getInstance(), GreenLight.getInstance()),
    GREEN_TO_FLASHING(GreenLight.getInstance(), FlashingLightGreen.getInstance()),
    FLASHING_TO_RED(FlashingLightGreen.getInstance(), RedLight.getInstance());


    TrafficLightState actually;
    TrafficLightState next;

    LightStateDescriptionPeople(TrafficLightState actually, TrafficLightState next) {
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

    @Override
    public TranspositionInterface getTranspositionFor(TrafficLightState now) {
        LightStateDescriptionPeople[] values = values();

        for (int i = 0; i < values.length; i++) {
            LightStateDescriptionPeople value = values[i];

            if (value.actually.equals(now)) {
                return value;
            }

        }


        return null;
    }
}
