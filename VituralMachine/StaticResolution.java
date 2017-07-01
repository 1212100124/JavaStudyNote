package VituralMachine;

/**
 * Created by jackie on 17-6-21.
 */
public class StaticResolution {

    // staitc 或者private 方法都是静态方法，在解析阶段就确定下来了。  字节码是invokestatic or invokespecical
    public static void sayHello(){
        System.out.println("hello world!");
    }

    public static void main(String args[]){
        sayHello();
    }
}
