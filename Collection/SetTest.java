package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
//        Set<Integer>  set=new HashSet<>();
//        set.add(55);
//        set.add(67);
//        set.add(55);
//        set.add(55);//每当有新元素加入，原本的顺序会被打乱,而如果没有元素变动，则顺序只会无序一次
//        System.out.println(set);
//        Set<Integer>  set=new LinkedHashSet<>();
//        set.add(55);
//        set.add(67);
//        set.add(65);
//        set.add(55);//每当有新元素加入，原本的顺序会被打乱,而如果没有元素变动，则顺序只会无序一次
//        System.out.println(set);
        Set<Integer>  set=new TreeSet<>();
        set.add(55);
        set.add(67);
        set.add(65);
        set.add(55);//每当有新元素加入，原本的顺序会被打乱,而如果没有元素变动，则顺序只会无序一次
        System.out.println(set);
        System.out.println(set);
    }
}
