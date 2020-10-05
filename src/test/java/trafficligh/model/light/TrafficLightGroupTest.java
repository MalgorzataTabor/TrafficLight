package trafficligh.model.light;


import impl.GreenLight;
import impl.RedLight;
import impl.TrafficLight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import trafficlight.model.state.LightStateDescription;
import trafficlight.model.state.LightStateDescriptionPeople;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightGroupTest  {

    public  TrafficLightGroup lightGroupRedStart;
    public  TrafficLightGroup lightGroupGreenStart;


    @BeforeEach

    public void setUp(){

        TrafficLight carLightRed = new TrafficLight(LightStateDescription.RED_TO_REDYELLOW);
        TrafficLight peopleLightRed = new TrafficLight(LightStateDescriptionPeople.RED_TO_GREEN);
        lightGroupRedStart = new TrafficLightGroup(carLightRed,peopleLightRed);


        TrafficLight carLightGreen = new TrafficLight(LightStateDescription.GREEN_TO_YELLOW);
        TrafficLight peopleLightGreen = new TrafficLight(LightStateDescriptionPeople.GREEN_TO_FLASHING);
        lightGroupGreenStart = new TrafficLightGroup(carLightGreen, peopleLightGreen);
    }

    @Test
     void changeCarToRed() {
        assertEquals(GreenLight.getInstance(), lightGroupGreenStart.getStateFor(LightModels.CAR_LIGHT));
        lightGroupGreenStart.changeToRedFor(LightModels.CAR_LIGHT);
        assertEquals(RedLight.getInstance(), lightGroupGreenStart.getStateFor(LightModels.CAR_LIGHT));
    }

    @Test
     void changePeopleToRed(){
        assertEquals(GreenLight.getInstance(),lightGroupGreenStart.getStateFor(LightModels.PEOPLE_LIGHT));
        lightGroupGreenStart.changeToRedFor(LightModels.PEOPLE_LIGHT);
        assertEquals(RedLight.getInstance(), lightGroupGreenStart.getStateFor(LightModels.PEOPLE_LIGHT));
    }




}