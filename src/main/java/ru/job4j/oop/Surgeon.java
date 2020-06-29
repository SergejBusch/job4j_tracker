package ru.job4j.oop;

public class Surgeon extends Doctor {
    private boolean hasInstruments = true;

    public void surgery(Pacient pacient) {
    }

    public boolean isHasInstruments() {
        return hasInstruments;
    }
}
