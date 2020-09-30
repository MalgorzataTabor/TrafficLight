package impl;

import trafficlight.model.state.TrafficLightState;

public interface TranspositionInterface {

    TrafficLightState getActual();
    TrafficLightState getNext();

    TranspositionInterface getTranspositionFor(TrafficLightState now);

}
