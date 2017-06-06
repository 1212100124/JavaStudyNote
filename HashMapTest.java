package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jackie on 17-6-2.
 */
public class HashMapTest {
    public static void main(String args[]){
        Map<String,String> mp = new HashMap<>();
        for(int i=0;i<=10;i++){
            mp.put(i+"",i+"");
        }
        /*
        *   总结一下三种遍历:
        *   (1)entrySet()迭代器是对于每个Node的迭代器，然后每次遍历就是遍历hashMap中的所有元素。
        *   调用entrySet().iterator().next()方法会调用nextNode()方法，去查找下一个Node.
        *   (2)keySet()迭代器与entrySet()的实现是一样的，只不过这个迭代器的next方法将会返回nextNode().key,然后在调用
        *   map.get(key)的方法来获得value,所以理论上来说第一种遍历肯定会比第二种遍历来的快
        *   (3)value()迭代器与entrySet的实现也是一样的，只不过迭代器的next方法将会返回nextNode().value.
        *
        * */
        //第一种遍历方式 利用entrySet()
        long startTime = System.currentTimeMillis(); // 获取开始时间
        Iterator t = mp.entrySet().iterator();
        while(t.hasNext()){
            Map.Entry m = (Map.Entry) t.next();
            //System.out.println(m);
        }
        long endTime = System.currentTimeMillis(); // 获取开始时间
        System.out.println("EntrySet程序运行时间： " + (endTime - startTime) + "ms");


        // 第二种遍历方式 利用KeySet();
        long startTime1 = System.currentTimeMillis(); // 获取开始时间
        Iterator kt = mp.keySet().iterator();
        while(kt.hasNext()){
            String key = (String)kt.next();
            String value = mp.get(key);
            //System.out.println(key+" = "+value);
        }
        long endTime1 = System.currentTimeMillis(); // 获取开始时间
        System.out.println("KeySet程序运行时间： " + (endTime1 - startTime1) + "ms");


        // 第三种遍历方式, 这种只是仅仅遍历value
        Iterator vt = mp.values().iterator();
        while(vt.hasNext()){
            String value = (String) vt.next();
        }

        // 添加元素/删除元素/替换元素/查找元素是否在集群中
        mp.put("jackie","handsome");
        if(mp.containsKey("jackie")){
            System.out.println("This hashMap contains jackie");
        }
        else{
            System.out.println("do not contains");
        }
        mp.replace("jackie","cool");
        System.out.println("the key of value is replaced by "+mp.get("jackie"));
        mp.remove("jackie");
        if(mp.containsKey("jackie")){
            System.out.println("This key still in!");
        }
        else{
            System.out.println("this key has been deleted!");
        }
    }


}


/*

EntrySet程序运行时间： 0ms
KeySet程序运行时间： 0ms
This hashMap contains jackie
the key of value is replaced by cool
this key has been deleted!


*/