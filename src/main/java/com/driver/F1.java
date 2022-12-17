package com.driver;

public class F1 extends Car {

    public F1()
    {

    }
    public F1(String name, boolean isManual) {
       super(name , 4 , 2 , 6 , isManual , "modern" , 2); //Use arbitrary values for parameters which are not mentioned
    }

    public void accelerate(int rate){
        int newSpeed = 0;
        newSpeed = currentSpeed + rate; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */

        if(newSpeed == 0) {
            stop();
            currentGear = 1;//Stop the car, set gear as 1
        }
        //for all other cases, change the gear accordingly

        if(newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection(newSpeed));
        }
    }
    public int getCurrentDirection(int speed)
    {
        if(speed <= 50) currentGear = 1;
        else if(speed <= 100 && speed > 50) currentGear = 2;
        else if(speed <= 150 && speed > 100) currentGear = 3;
        else if(speed <= 200 && speed > 150) currentGear = 4;
        else if(speed <= 250 && speed > 200) currentGear = 5;
        else currentGear = 6;
        return currentDirection;
    }
}
