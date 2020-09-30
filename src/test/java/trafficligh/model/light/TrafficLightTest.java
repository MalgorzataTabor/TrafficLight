package trafficligh.model.light;


import impl.GreenLight;
import impl.RedLight;
import impl.RedYellow;
import impl.YellowLight;
import org.junit.Assert;
import org.junit.Test;
import trafficlight.model.state.LightStateDescription;
import trafficlight.model.state.TrafficLightState;

public class TrafficLightTest {

    @Test
    public void trafficLightTest(){

        TrafficLight trafficLight = new TrafficLight(LightStateDescription.GREEN_TO_YELLOW);

        TrafficLightState state = trafficLight.getState();


        Assert.assertEquals(GreenLight.getInstance(), state);
        Assert.assertEquals(true, state.canGo());
        Assert.assertEquals(false, state.shouldStop());

        trafficLight.changeStateToNext();
        state=trafficLight.getState();

        Assert.assertEquals(YellowLight.getInstance(), state);
        Assert.assertEquals(true, state.canGo());
        Assert.assertEquals(false, state.shouldStop());



    }

    @Test
    public void trafficLightTest1(){


        TrafficLight trafficLight = new TrafficLight(LightStateDescription.RED_TO_REDYELLOW);
        TrafficLightState state = trafficLight.getState();

        Assert.assertEquals(RedLight.getInstance(), state);
        Assert.assertEquals(false, state.canGo());
        Assert.assertEquals(true, state.shouldStop());

        trafficLight.changeStateToNext();
        state= trafficLight.getState();

        Assert.assertEquals(RedYellow.getInstance(), state);
        Assert.assertEquals(false, state.canGo());
        Assert.assertEquals(true, state.shouldStop());


    }

}