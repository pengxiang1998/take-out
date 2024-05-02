package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest {
    public static void main(String[] args) {
        //为集合（Collection)批量添加元素，传入的参数分别是要插入的集合对象以及要添加的数据
        ArrayList<String> names=new ArrayList<>();
        Collections.addAll(names,"李白","杜甫","白居易");
        System.out.println(names);
        //打乱List集合中的元素顺序
        Collections.shuffle(names);
        System.out.println(names);
        //对List集合中的元素按照升序进行排序
        Collections.sort(names);
        System.out.println(names);


        ArrayList<Students> students=new ArrayList<>();
        Collections.addAll(students,new Students("李白",28),new Students("杜甫",19),new Students("白居易",29));
        System.out.println(students);
        Collections.shuffle(students);
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
        Collections.sort(students, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        System.out.println(students);

    }
}
