package Maps;

import java.util.HashMap;
import java.util.Map;

public class MapTest {


    public static void main(String[] args) {
        Map<String,Integer> hashmap=new HashMap<>();
        hashmap.put("手表",120);
        hashmap.put("Java",10);
        hashmap.put("电脑",220);
        hashmap.put("手表",180);
        System.out.println(hashmap);


    }
}
