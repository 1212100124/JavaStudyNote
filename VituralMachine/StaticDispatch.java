package VituralMachine;

/**
 * Created by jackie on 17-6-21.
 */
public class StaticDispatch {
    static abstract class human{

    }

    static class man extends human{
    }

    static class woman extends human{

    }

    public static void sayHello(human guy){
        System.out.println("hello guy!!");
    }

    public static void sayHello(man guy){
        System.out.println("I'm Man");
    }

    public static void sayHello(woman guy){
        System.out.println("I'm woman");
    }

    public static void main(String args[]){
        human m = new man();
        human w = new woman();
        sayHello(m);
        sayHello(w);
        sayHello((man)m);
        sayHello((woman)w);
    }
}
