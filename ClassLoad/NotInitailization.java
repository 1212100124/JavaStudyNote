package ClassLoad;

/**
 * Created by jackie on 17-6-21.
 */
public class NotInitailization {
    public static void main(String args[]){
        // 不引发父类子类的初始化
        System.out.println(SubClass.value);
        // 引发父类加载，但是不引发子类加载，java虚拟机能不加载类就不加载类
        System.out.println(SubClass.loadValue);
        // 不引发类加载,但是会引发数组类的加载，java会有偷偷有数组类 厉害的不行
        //SuperClass[]sca = new SuperClass[10];
    }
}

class SuperClass{
    static{
        System.out.println("Super.Class");
    }
    // 这部分是编译的时候就进常量池的，因此不引发类加载
     public final static String value="123";
    // 在读取或设置一个类的静态字段，以及调用一个类的静态方法的时候会加载类
    public static int loadValue=234;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass.Class");
    }
}


