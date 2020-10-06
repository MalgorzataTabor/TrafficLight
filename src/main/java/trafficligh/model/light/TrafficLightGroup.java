package trafficligh.model.light;

import impl.TrafficLight;
import trafficlight.model.state.TrafficLightState;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TrafficLightGroup {
    private List<TrafficLight> lightsList;

    public TrafficLightGroup(TrafficLight... lightsList) {
        this.lightsList = Arrays.asList(lightsList);
    }

    public TrafficLightState getStateFor(LightModels model) {
        Optional<TrafficLight> first = lightsList.stream()
                .filter(p -> p.getTranspositionClass().equals(model.getTranspositionClass()))
                .findFirst();
        if (first.isPresent()) {
            return first.get().getState();
        } else {
            return null;
        }
    }


    public void changeToRedFor(LightModels model) {
        lightsList.stream()
                .filter(p -> p.getTranspositionClass().equals(model.getTranspositionClass()))
                .forEach(p -> {
                    while (p.getState().canGo() || !p.getState().shouldStop()) {
                        p.changeStateToNext();
                    }
                });
    }

    public void changeToGreenFor(LightModels model) {
        lightsList.stream()
                .filter(p -> p.getTranspositionClass().equals(model.getTranspositionClass()))
                .forEach(p -> {
                    while (!p.getState().canGo() || p.getState().shouldStop()) {
                        p.changeStateToNext();
                    }
                });
    }

    public void changeAllToRed() {
        boolean areAllRed = lightsList.stream()
                .allMatch(p -> !p.getState().canGo() && p.getState().shouldStop());

        while (!areAllRed) {
            for (TrafficLight trafficLight : lightsList) {
                if (trafficLight.getState().canGo() || !trafficLight.getState().shouldStop()) {
                    trafficLight.changeStateToNext();
                }
            }
            areAllRed = lightsList.stream()
                    .allMatch(p -> !p.getState().canGo() && p.getState().shouldStop());
        }
    }

    public void changeAllToGreen() {
        boolean areAllRed = lightsList.stream()
                .allMatch(p -> p.getState().canGo() && !p.getState().shouldStop());

        while (!areAllRed) {
            for (TrafficLight trafficLight : lightsList) {
                if (!trafficLight.getState().canGo() || trafficLight.getState().shouldStop()) {
                    trafficLight.changeStateToNext();
                }
            }
            areAllRed = lightsList.stream()
                    .allMatch(p -> p.getState().canGo() && !p.getState().shouldStop());
        }
    }
}
