package initialization;

/**
 * Created by bczhang on 2016/5/19.
 */
public class SubClass extends Parent {
    // 静态变量
    public static String s_StaticField = "子类--静态变量";
    // 变量
    public String s_Field = "子类--变量";
    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }
    // 初始化块  http://ini.iteye.com/
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }
    // 构造器
    public SubClass() {
        System.out.println("子类--构造器");
    }
    // 程序入口
    public static void main(String[] args) {
        new SubClass();
    }
    /*
    the result:
父类--静态变量
父类--静态初始化块
子类--静态变量
子类--静态初始化块
父类--变量
父类--初始化块
父类--构造器
子类--变量
子类--初始化块
子类--构造器
     */
}