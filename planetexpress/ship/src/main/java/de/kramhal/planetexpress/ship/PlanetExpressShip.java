package de.kramhal.planetexpress.ship;

public class PlanetExpressShip
{
    private int speed = 0;

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void flyTo(String planet){
        System.out.println("Launching... ");
        System.out.println("Setting autopilot for ["+planet+"]");
        System.out.println("Okay, we are there!");

    }

}
