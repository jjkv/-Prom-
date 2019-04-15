import java.util.*;
import java.lang.reflect.*;

class Micah {

    /* teenagers have a surprisingly standardized communication protocol */
    private static final String askMethod = "askedToPromBy";

    /* micah the extrovert (a whelmed one) */
    public static String mood = "meh";

    /* please be Hannah */
    public static void askToProm(String date_name) {

        try {
            Class<?> asking        = Class.forName(date_name);
            Method   cheesy_poster = asking.getMethod(askMethod, Micah.class);
            
            /* i invoke, CHEESY POSTER (* gasp *)*/
            cheesy_poster.invoke(null, Micah.class.newInstance());            
        /* catching the following exceptions individually is mostly just for fun */
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

/* everything is static because women aren't objects */
class Hannah {

    public static String answer = "";

    /* decided to give Micah the win here in accordance with the poster itself */
    public static void askedToPromBy(Micah m) { answer = "yes"; }

    /* pandering: 
    public static void askedToPromBy(Chad c)   { answer = "YES"; } 
    public static void askedToPromBy(Virgin v) { answer = "ew";  }
    */
}   

/* 
problems: 
 - `==` instead of `.equals()` is BAD
 - `Hannah.answer` should be a boolean
 - askToProm should a Hannah instance
 - Micah and Hannah should be singleton objects
 - //Prom? 
 - poor use of naming idioms
 - storing mood as string, rather than possibly enum of emotions
 */
public class Prom {

    public static void main(String [] argv) {
        Micah.askToProm("Hannah");
        if(Hannah.answer == "yes") {
            Micah.mood = "Happy";
        } else {
            /* you're done kiddo */
            System.out.println("hannah's answer: "+Hannah.answer);
        }                
        System.out.println("Micah's mood: "+Micah.mood);
    }
}
