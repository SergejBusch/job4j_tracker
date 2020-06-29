package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("go");
    }

    @Override
    public void travellers(int travellers) {
        System.out.println("there are " + travellers + " travelers");
    }

    @Override
    public int fuel(int fuel) {
        System.out.println(fuel + " is fueled");
        return fuel;
    }
}
