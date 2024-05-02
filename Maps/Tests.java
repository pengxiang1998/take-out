package Maps;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Tests {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap();
        ArrayList<String> city1=new ArrayList<>();
        Collections.addAll(city1,"济南","青岛","临沂");
        hashMap.put("山东省", city1);
        ArrayList<String> city2=new ArrayList<>();
        Collections.addAll(city2,"南京","苏州","徐州");
        hashMap.put("江苏省", city2);
        System.out.println(hashMap);
        hashMap.forEach((p,c)->{
            System.out.println(p + "---" + c);
        });
        List<String> citys=hashMap.get("江苏省");
        for (String c:citys){
            System.out.println(c);
        }
        List<String> cs1=new ArrayList<>();
        for(String city:citys){
            if(city.contains("州")){
                cs1.add(city);
            }
        }
        System.out.println(cs1);

        citys.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("州");
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        List<String> cs2=citys.stream()//将集合转换为stream流
                .filter(s->s.contains("州"))
                .collect(Collectors.toList());
        System.out.println(cs2);
    }
}
