package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FelectTest {
    private int id;
    private String name;
    public void show(String name){
        System.out.println(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FelectTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public FelectTest(int id) {
        this.id = id;
    }

    public FelectTest() {
    }

    @Override
    public String toString() {
        return "FelectTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<FelectTest> felect= (Class<FelectTest>) Class.forName("Reflect.FelectTest");
        System.out.println("类对象："+felect);//类对象
        Constructor[] constructors=felect.getConstructors();
        System.out.println("无参构造方法："+constructors);//无参构造函数

        Constructor constructorint=felect.getConstructor(int.class);
        System.out.println(constructorint);//形参为int的构造函数
        Object obj=constructorint.newInstance(1);//使用构造函数创建对象
        Method method=felect.getMethod("setName",String.class);//获取名字为setName,参数为String类型的方法
        method.invoke(obj,"李白");//执行方法，需要传入对象和参数
        Method methodget=felect.getMethod("getName");//获取名字为getName的get方法
        methodget.invoke(obj);//执行getName方法

        Field[] fields=felect.getDeclaredFields();//获取所有属性
        for (Field field : fields) {
            System.out.println("属性："+field);
        }

        Field id=felect.getDeclaredField("id");
        System.out.println(id);//获取属性名称为id的属性
        Method methods=felect.getDeclaredMethod("show",String.class);
        Object object=felect.getConstructor().newInstance();
        methods.invoke(object,"李白");


    }
}
