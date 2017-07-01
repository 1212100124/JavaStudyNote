package generics;

import java.io.Serializable;

/**
 * Created by jackie on 17-5-22.
 *
 * class of a generic
 */
public class Pair<T> {
    private T first ;
    private T second;
    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first ,T second){
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first){
        this.first = first;
    }

    public void setSecond(T second){
        this.second = second;
        System.out.println("Pair's method!!");
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public String toString() {
        return "first = "+first+" second = "+second;
    }

    public static void main(String args[]){
        String a[] = {"123","234","323"};
        Pair<String> p = ArrayAlg.getminAndMax(a);
        System.out.println(p);
        // 11）这是不允许的 ，  泛型类的特定类型继承但是实际泛型是没有太大关系
        //Pair<Employee> ps = new Pair<Manager>();

        //
        Pair<Manager> managerBuddies = new Pair<>();
        Pair<? extends  Employee> wildcardBuddies = managerBuddies;

        /*
        *  下面语句将不会通过编译， 编译器只知道它需要某个 Employee的子类型，但不知道具体是什么类型。？不能用来匹配
        * */
        //wildcardBuddies.setFirst(new Employee());

        // <? super Manager>  这个是有set方法的， 只要是子类都可以调用


        /*
            直观的讲，带有超类型限定的通配符可以向泛型对象写入，带有子类型限定的通配符可以从泛型对象读取
        */
        Pair<? extends Employee> testWildcardBuddies = new Pair<>(new Manager(),new Manager());
         //testWildcardBuddies.setFirst(new Manager()); // error cannot know the type of setFirst()


        // ? 匹配的类型是Employee的超类，所以任意一个 Employee的子类都行
        Pair<? super Employee> testSuperWildcardBuddies = new Pair<>(new Manager(),new Manager());
        testSuperWildcardBuddies.setFirst(new Manager());
        Object e =testSuperWildcardBuddies.getFirst();

        //无限通配符



    }

}

/**
 * 测试generic method and 类型限定
 *
 * */
class ArrayAlg{
    // generic method
    public static <T> T getMiddle(T[] a){
        return a[a.length/2];
    }

    /**
     * 返回最小值
     * 这是类型变量的限定类型T都必须要是实现了Comparable借口的类
     * 限定类用 & 来分开
     * */
    public static  <T extends Comparable&Serializable> T getMin(T[] a){
        T min=a[0];
        for(int i=1;i<a.length;i++){
            if(min.compareTo(a[i])>0){
                min = a[i];
            }
        }
        return min;
    }

    public static <T extends Comparable> Pair<T> getminAndMax(T[] a){
        T min = a[0];
        T max = a[0];
        for(int i=1;i<a.length;i++){
            if(min.compareTo(a[i])>0){
                min = a[i];
            }
            if(max.compareTo(a[i])<0){
                max = a[i];
            }
        }
        return new Pair<T>(min,max);
    }

}

class person implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "I'm person";
    }
}

class Employee extends person implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "I'm Employee";
    }
}

class Manager extends Employee implements Comparable{
    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return "I'm Manager";
    }
}


