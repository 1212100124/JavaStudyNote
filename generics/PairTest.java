package generics;

import java.util.Scanner;

/**
 * Created by jackie on 17-5-24.
 */
class PairT<T> {
    T first;
    T second;
    public PairT(T first,T second){
        this.first = first;
        this.second = second;
    }

    public void setFirst (T first){
        this.first = first;
    }

    public void setSecond (T second){
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }
}

public class PairTest{
    public static void main(String args[]){
        // 并没有为Pairt 设置具体的类型
        PairT<? super Manager> p = new PairT<>(new Employee(),new Employee());
        Object e = p.getSecond();
        System.out.println(e);

        Pair<? extends Employee> pe = new Pair<>(new Employee(),new Employee());
        person ee =pe.getFirst();
        System.out.println(ee);


        Scanner in = new Scanner(System.in);
        String name = in.next();

        try{
            Class c1 = Class.forName(name);
            System.out.println(c1);
        }catch (Exception E){
            E.printStackTrace();
        }
    }


}

