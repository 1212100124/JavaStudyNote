package Collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jackie on 17-6-20.
 */
public class TreeMapTest {
    public static void main(String args[]){
        Map<String,String> mp = new TreeMap(new Comparator<String>() {
            /*
             * int compare(Object o1, Object o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        mp.put("jackie","cool");
        mp.put("mike","sb");
        Iterator s= mp.entrySet().iterator();
        while(s.hasNext()){
            Map.Entry me = (Map.Entry) s.next();
            System.out.println(me.getKey()+" "+me.getValue());
        }
    }
}
