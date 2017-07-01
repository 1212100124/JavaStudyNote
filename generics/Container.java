package generics;

import java.lang.reflect.Constructor;

/**
 * Created by jackie on 17-5-22.
 */
public class Container<K,V> {
    private K key;
    private V value;
    public Container(K key,V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void setKey(K key){
        this.key = key;
    }

    public void setValue(V value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "key = "+key+" value = "+value;
    }

    public static  void main(String args[]){
        Container<String,String> ss= new Container<>("jackie","test");
        Container<Integer,String> is = new Container<>(1,"jackie");
        System.out.println(ss.getClass()+ " " +ss);
        System.out.println(is.getClass()+" "+is);
    }

}
