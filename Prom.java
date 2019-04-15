import java.util.*;
import java.lang.reflect.*;

class Micah {

    private static final String askMethod = "askedToPromBy"; 
    public static String mood = "meh";
    
    public static void askToProm(String date_name) {
        try {
            Class<?> asking = Class.forName(date_name);
            Method cheesy_poster = asking.getMethod(askMethod, Micah.class);
            cheesy_poster.invoke(null, Micah.class.newInstance());
        } catch (ClassNotFoundException e) {
            mood = "hannah wya?";
        } catch (NoSuchMethodException e) {
            mood = "maybe she doesnt want to go to prom???";
        } catch (IllegalAccessException e) {
            mood = "shit";
        } catch (InvocationTargetException e) {
            mood = "guilty";
        } catch (Throwable t) {
            System.err.println("PROBLEM: "+t);
        }
    }
}

class Hannah {

    public static String answer = "";

    public static void askedToPromBy(Micah m) { answer = "yes"; }

    /* public static void askedToPromBy(Chad c) { answer = "YES"; } */
}

public class Prom {

    public static void main(String [] argv) {
        Micah.askToProm("Hannah");
        if(Hannah.answer == "yes") {
            Micah.mood = "Happy";
        } else {
            System.out.println("hannah's answer: "+Hannah.answer);
        }                
        System.out.println("Micah's mood: "+Micah.mood);
    }
}
