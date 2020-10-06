package trafficligh.model.light;

import impl.TrafficLight;
import trafficlight.model.state.LightStateDescription;
import trafficlight.model.state.LightStateDescriptionPeople;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1, true);

        TrafficLight model = LightModels.CAR_LIGHT.getModel();
        TrafficLight model1 = LightModels.PEOPLE_LIGHT.getModel();


        TrafficLightGroup trafficLightGroup = new TrafficLightGroup(model, model1);
        trafficLightGroup.changeToRedFor(LightModels.CAR_LIGHT);


        TrafficLight carLightG1 = new TrafficLight(LightStateDescription.RED_TO_REDYELLOW);
        TrafficLight peopleLightG1 = new TrafficLight(LightStateDescriptionPeople.RED_TO_GREEN);
        TrafficLightGroup lightGroupFirst = new TrafficLightGroup(carLightG1, peopleLightG1);

        TrafficLight carLightG2 = new TrafficLight(LightStateDescription.RED_TO_REDYELLOW);
        TrafficLight peopleLightG2 = new TrafficLight(LightStateDescriptionPeople.RED_TO_GREEN);
        TrafficLightGroup lightGroupSecond = new TrafficLightGroup(carLightG2, peopleLightG2);

        LightThread threadFirst = new LightThread("Grupa Pierwsza", lightGroupFirst, semaphore);
        LightThread threadSecond = new LightThread("Grupa Druga", lightGroupSecond, semaphore);

        threadFirst.start();
        threadSecond.start();
    }
}
