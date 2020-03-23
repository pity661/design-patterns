package com.wenky.静态类;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-27 11:41
 **/
public class MainInStaticClass {

    private String param = "外部类private变量";

    private static String staticParam = "外部类静态变量";

    // 静态内部类又叫类内部类
    static class StaticMain {
        static void main() {
            // System.out.println(MainInStaticClass.this.param); // 不能访问外部类的实例成员变量
            System.out.println(staticParam); // 能访问外部类的静态成员变量
            System.out.println(MainInStaticClass.staticParam);
            new MainInStaticClass().print();
        }
    }

    // 普通内部类不能有静态成员
    class CommonMain {
        // private static String staticParam = "111"; // 非静态内部类中不能定义静态成员变量和方法
        private String param = "普通内部类全局变量"; //优先使用内部类的局部变量
        void main() {
            String param = "普通内部类方法变量";
            System.out.println(param); // 内部类方法变量
            System.out.println(this.param); // 内部类变量
            System.out.println(MainInStaticClass.this.param); // 通过 {外部类类名.this.参数名} 访问外部类参数
            new MainInStaticClass().print();
        }
    }

    public static void main(String[] args){
        new MainInStaticClass().print();
    }

    public void print(){
        System.out.println("main in static inner class");
    }
}
