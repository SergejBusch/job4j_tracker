package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException{
        int rsl = -1;
        for(String val : value) {
            rsl++;
            if (val.equals(key)) {
                return rsl;
            }
        }
        throw new ElementNotFoundException("element not found");
    }

    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[] {"a", "b"}, "c");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}