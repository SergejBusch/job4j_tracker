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

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        // if contains throw ElementAbuseException
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }

}

    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[] {"a", "b"}, "c");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}