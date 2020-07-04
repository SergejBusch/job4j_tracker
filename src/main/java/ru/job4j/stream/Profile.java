package ru.job4j.stream;

public class Profile {

    public Profile(Address address) {
        this.address = address;
    }

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
