package JavaThread;

/**
 * Created by jackie on 17-6-23.
 */
public class Singleton {
    private volatile static Singleton instance;
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if (instance == null){

                }
            }
        }
        return instance;
    }

    public static void main(String args[]){
        Singleton.getInstance();
    }
}
