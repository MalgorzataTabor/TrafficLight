package trafficligh.model.light;

import impl.TrafficLight;
import impl.TranspositionInterface;
import trafficlight.model.state.LightStateDescription;
import trafficlight.model.state.LightStateDescriptionPeople;

public enum LightModels {

    CAR_LIGHT(LightStateDescription.RED_TO_REDYELLOW),
    PEOPLE_LIGHT(LightStateDescriptionPeople.RED_TO_GREEN);


    private TranspositionInterface transpositionInterface;

    LightModels(TranspositionInterface transpositionInterface) {
        this.transpositionInterface = transpositionInterface;
    }

    public Class<? extends TranspositionInterface> getTranspositionClass() {

        return transpositionInterface.getClass();
    }

    public TrafficLight getModel() {
        return new TrafficLight(transpositionInterface);
    }
}
