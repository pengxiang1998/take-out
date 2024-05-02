package Optional;

//继承 Exception 类-----自定义的异常类
public class MyException extends Exception {
    //传递数字  大于10
    private int detail;

    public MyException(int a) {
        this.detail = a;
        System.out.println("发生异常");
    }

    //异常打印信息

}

class Test {
    //可能会存在异常的方法
    static void test(int a) throws MyException {
        System.out.println("传递的参数为:" + a);
        if (a > 10) {
            throw new MyException(a);//抛出
        }
        System.out.println("OK");
    }

    public static void main(String[] args) throws MyException {
        try {
            test(11);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
