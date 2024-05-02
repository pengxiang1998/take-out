package Stream;

import java.util.*;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        List list=new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5);
        Stream stream = list.stream();
        stream.filter(o -> {
            int i= (int) o;
            return i>=2;
        }).forEach(o -> System.out.print(o));

        Integer[] arr={1,2,3,4,5,6,7,8};
        Stream<Integer> stream1 = Arrays.stream(arr);
        Stream<Integer> stream2 = Stream.of(arr);
        stream1.filter(s->s>=2).forEach(s->System.out.print(s));
        stream2.forEach(s->{
            System.out.print(s);
        });
        //对于双列集合，将其转换为单列集合后再创建Stream流
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("李白",135);
        hashMap.put("杜甫",123);
        hashMap.put("白居易",234);
        //通过entrySet方法可以将map转换为set
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        System.out.println();
        //set可以创建stream流
        Stream<Map.Entry<String, Integer>> stream3 = entries.stream();
        stream3.forEach(s->{
            System.out.println(s);
        });


    }
}
