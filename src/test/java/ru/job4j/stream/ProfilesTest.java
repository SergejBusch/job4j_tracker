package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

public class ProfilesTest {

    @Test
    public void whenTwoSameAddresses() {
        Address client1Address = new Address("Javaburg", "Reference St", 5, 1);
        Profile client1 = new Profile(client1Address);
        Address client2Address = new Address("Javaburg", "Reference St", 5, 1);
        Profile client2 = new Profile(client2Address);
        List<Profile> profiles = List.of(client1, client2);
        List<Address> rsl = new Profiles().collect(profiles);
        Assert.assertThat(rsl, is(List.of(client1Address)));
    }
}
