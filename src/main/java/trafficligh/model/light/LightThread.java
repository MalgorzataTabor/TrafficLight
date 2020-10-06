package trafficligh.model.light;

import java.util.concurrent.Semaphore;

public class LightThread extends Thread {


    private TrafficLightGroup group;
    private Semaphore semaphore;


    public LightThread(String name, TrafficLightGroup group, Semaphore semaphore) {
        super(name);
        this.group = group;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {

        System.out.println("Thread " + this.getName() + "started");

        while (true) {

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----------" + this.getName() + " Start -------------");
            printLightState();
            group.changeToGreenFor(LightModels.PEOPLE_LIGHT);
            group.changeToGreenFor(LightModels.CAR_LIGHT);
            printLightState();

            try {
                sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            group.changeAllToRed();
            printLightState();
            System.out.println("-----------" + this.getName() + " End -------------");
            semaphore.release();
        }
    }

    private void printLightState() {
        System.out.print(this.getName() + " people light: ");
        group.getStateFor(LightModels.PEOPLE_LIGHT).printState();

        System.out.print(this.getName() + " car light: ");
        group.getStateFor(LightModels.CAR_LIGHT).printState();
    }

}
