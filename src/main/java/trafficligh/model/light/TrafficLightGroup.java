package trafficligh.model.light;

import trafficlight.model.state.TrafficLightState;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TrafficLightGroup {

    private List<TrafficLight> lightList;

    public TrafficLightGroup(TrafficLight...lightsList) {
        this.lightList = Arrays.asList(lightsList);
    }

    public TrafficLightState getStateFor(LightModels model){


        Optional<TrafficLight> first = lightList.stream()
                .filter(p -> p.getTranspositionClass().equals(model.getTranspositionClass()))
                .findFirst();


        if(first.isPresent()){
            return first.get().getState();
        }else {
            return null;
        }
    }
}
