package trafficligh.model.light;

import impl.TranspositionInterface;
import trafficlight.model.state.TrafficLightState;

public class TrafficLight {


    private TranspositionInterface transposition;

    public TrafficLight(TranspositionInterface transposition) {
        this.transposition = transposition;
    }

    public Class<? extends TranspositionInterface> getTranspositionClass() {

        return transposition.getClass();
    }

    public TrafficLightState getState() {
        return transposition.getActual();
    }

    public void changeStateToNext() {
        transposition = transposition.getTranspositionFor(transposition.getNext());
    }
}
