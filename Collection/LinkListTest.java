package Collection;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LinkListTest {
    public static void main(String[] args) {

//        LinkedList<String> queue=new LinkedList<>();
//        queue.addLast("第一个");
//        queue.addLast("第二个");
//        queue.addLast("第三个");
//
//        System.out.println(queue.removeFirst());
//        System.out.println(queue);

        LinkedList<String> stack=new LinkedList<>();
        stack.addFirst("第一个");
        stack.addFirst("第二个");
        stack.addFirst("第三个");

        System.out.println(stack.removeFirst());
        System.out.println(stack);
    }



}
