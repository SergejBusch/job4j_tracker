package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static ru.job4j.stream.FlatmapStream.helper;
import static org.hamcrest.core.Is.is;

public class FlatmapStreamTest {

    @Test
    public void twoDimensionArrayThenAList() {
        Integer[][] matrix = {{1, 2}, {3, 4, 5}};
        List<Integer> listOfInteger = helper(matrix);
        Assert.assertThat(listOfInteger, is(List.of(1, 2, 3, 4, 5)));
    }
}
