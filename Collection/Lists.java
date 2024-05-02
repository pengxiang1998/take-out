package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Lists {
    public static void main(String[] args) {
        Collection<Integer> collection=new ArrayList<>();
        collection.add(1);
        collection.add(4);
        collection.add(66);
        System.out.println(collection);
        //从集合对象中获取迭代器对象
        Iterator<Integer> iterator=collection.iterator();
        //获取的迭代器默认是指在第一个位置的
        System.out.println(iterator.next());
        //结合while循环输出迭代器结果
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        String[] strings={"李白","杜甫","白居易"};
        for (String idex : strings){
            System.out.println(idex);
        }
        for (Integer idex : collection){
            System.out.println(idex);
        }


    }

}
