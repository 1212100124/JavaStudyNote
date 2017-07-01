package generics;

import java.util.Date;

/**
 * Created by jackie on 17-5-22.
 *
 * 1）虚拟机没有泛型类型对象——所有对象都是普通类
 *
 * 2）无论何时定义一个泛型类型，相应的原始类型（raw type）都会被自动提供
 *
 * 3）原始类型用第一个边界的类型变量来替换 ，如果没有给定限定则用Object替换
 *
 * 4) 桥方法被合成为保持多态的
 *
 */
public class GenericWithVirtual<T> {
    // 9) 不能在静态域或方法中引用类型变量
    //private static T singleInstatnce;


    T A;
    public GenericWithVirtual(){
    }
    public GenericWithVirtual(T a){
        A=a;
    }

    public static void main(String args[]){
        /*
        *  The ans is DataInterval's method!!
        * */
        DateInterval di = new DateInterval();
        di.setSecond(new Date());
    }
}

class DateInterval extends Pair<Date>{
    public void setSecond(Date second){
        System.out.println("DateInterval's method!!");

        /*
        * 5）运行时类型查询，类型是会被擦除的
        *
        * */
        Pair<String> a = new Pair<>();
        if(a instanceof Pair){
            System.out.println("yes it is!");
        }
        Pair<String> stringPair = new Pair<>();
        Pair<Integer> intergerPair = new Pair<>();
        if(stringPair.getClass() == intergerPair.getClass()){
            System.out.println("yes it is again!");
        }

    }

    /*
    *  6）不能抛出也不能捕获泛型类的对象。实际上泛型类扩展Throwable都不合法
    * */
   // public class Problem<T> extends Exception   泛型累不能继承异常


    /*
    不能捕获异常
    public static <T extends Throwable> void doWork(Class<T> t){
        try{

        }catch (T e){

        }
    }*/


    //但是在异常声明中可以使用类型变量
    // 因为这个T 可以是一个Exception
    public static <T extends  Throwable>void doWord(T t) throws T{
    /*
    *
    * 7)不能声明参数化类型的数组
    *
    *
    * */
       Pair<String>[]table = new Pair[10];
       table[0] = new Pair<String>();


       //8) 不能实例化泛型类型
       // new T();
    }
}


//10） 泛型类型的继承规则



