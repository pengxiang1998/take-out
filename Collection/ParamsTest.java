package Collection;

import java.util.Arrays;

public class ParamsTest {
    public static void main(String[] args) {
        test();
        test(1);
        test(1,2,3,5);
        test(new int[] {1,2,5,76});
    }
    public static void test(int... num){
        //获得的参数是当作数组来处理的
        System.out.println(num.length);
        System.out.println(Arrays.toString(num));

    }
}
