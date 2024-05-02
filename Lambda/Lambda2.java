package Lambda;

import java.util.function.IntConsumer;

public class Lambda2 {
    public static void main(String[] args) {
        forEachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        forEachArr((int value)->{
            System.out.println(value);
        });
    }
    public static void forEachArr(IntConsumer intConsumer){
        int[] arr={1,2,3,4,5,6,7,8};
        for(int i:arr){
            intConsumer.accept(i);
        }

    }
}
