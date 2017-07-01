package Collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jackie on 17-6-20.
 */
public class ConcurrentTest {
    public static void main(String args[]){
        ConcurrentHashMap<String,String> ctm  = new ConcurrentHashMap();
        ctm.put("jackie","cool");
    }
}
