package com.letslearntogether.madkart

class Car(val engine : Engine) {

    fun start(){
        engine.start()
    }

    //Problems
/*
    Car & Engine are tightly coupled
    - Change the engine, then change the car & its respective methods
    - Both are dependendent on each other
    Hard to test
*/

}

class Test{

    fun main(){
        //val car = Car()
        //car.start()

        val hCar = HydrogenEngine()
        hCar.start()

        val eCar = ElectricEngine()
        eCar.start()

        val gCar = GasEngine()
        gCar.start()


    }
}
