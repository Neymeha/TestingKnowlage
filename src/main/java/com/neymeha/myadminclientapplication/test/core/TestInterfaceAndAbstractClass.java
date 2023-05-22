package com.neymeha.myadminclientapplication.test.core;

public class TestInterfaceAndAbstractClass extends Air implements Voice{
    {setHumidity("53%");setPressure("1 atmosphere");}
    @Override
    void airStats() {
        System.out.println(humidity+" "+pressure);
    }

    @Override
    public void say() {
        System.out.println("fuck off im singing:");
        sing();
    }

    public static void main(String[] args) {
        TestInterfaceAndAbstractClass test = new TestInterfaceAndAbstractClass();
        test.airStats();
        System.out.println();
        test.say();
        System.out.println();
        Voice.paramPamPam();
        System.out.println(Voice.x);
    }
}

interface Voice{
    int x=1;
    default void sing(){
        System.out.println("La-La-La");
        toDoDo();
    }
    void say();
    private void toDoDo(){
        System.out.println("to-do-do");
    }
    static void paramPamPam(){
        System.out.println("param-Pam-Pam");
    }
}

abstract class Air{
    String humidity;
    String pressure;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    abstract void airStats();
}
