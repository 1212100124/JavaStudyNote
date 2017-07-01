package ClassLoad;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by jackie on 17-6-21.
 */
public class LocalVar {
    /*
    * 常量池是方法区的一部分，方法区主要存放字面量和符号引用
    * */
    public static void main(String args[]){
        // 都是放在常量池的，有一个字符串池，相同字符串只会存一个
        String s1 = "abc";
        String s2 = "abc";
        //所以s1,s2都是指向同一个对象
        System.out.println("s1==s2: "+(s1==s2));
        //这个时候s1,s2的数值都是abc, 所以肯定相同
        System.out.println("s1.equals(s2)"+s1.equals(s2));

        // 在heap中生成了两个对象，因此s3,s4指向的地址是不一样的
        // 但是equals比的是具体的值，所以是一样的
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println("s3==s4: "+(s3==s4));
        System.out.println("s3.equals(s4)"+s3.equals(s4));


        // 虚拟机在编译的时候会优化，直接在 常量池生成字符串"abcd"
        String str1="ab"+"cd";
        String str2="abcd";
        //因此这个str1,str2 都是指向常量池中的abcd
        System.out.println("str1==str2: "+(str1==str2));
        System.out.println("str1.equals(str2)"+str1.equals(str2));

        //str3 ,str4 都会指向方法区中的字符串没错
        String str3 = "ab";
        String str4 = "cd";
        // jvm首先会利用 str3指向的字符串创建一个Stringbuilder类
        // 然后调用 StringBuidler的append方法，构造出abcd这么 StringBuilder类
        // 最后再调用StringBuidler的 toString方法在堆中生成一个String
        String str5 = str3+str4;
        // 所以这个肯定是不一样的
        System.out.println("str2==str5: "+(str2==str5));
        // 数值是一样的
        System.out.println("str2.equals(str5)"+str1.equals(str5));

        //final 是常量，编译器会优化，也就是直接用具体的值带入
        final String str6 = "ab";
        final String str7 = "cd";
        // 所以这句话就形同于str8  = "ab"+"cd";
        String str8 = str6+str7;
        // 所以这个值是一样的，都是指向"abcd"
        System.out.println("str2==str8: "+(str2==str8));
        // 这个值肯定是一样的
        System.out.println("str2.equals(str8)"+str1.equals(str8));


        String str;

    }

}

class testFinal{
    private int a=1;
    public int getA(){
        return a;
    }
    public void setA(){
        a =2 ;
    }
}
