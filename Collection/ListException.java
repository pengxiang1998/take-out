package Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ListException {
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList();
        arrayList.add("李白");
        arrayList.add("小李子");
        arrayList.add("杜甫");
        arrayList.add("李世民");
        arrayList.add("李广");
        arrayList.add("白起");
        System.out.println(arrayList);
        Iterator<String> iterator=arrayList.iterator();
        while (iterator.hasNext()){
            String name=iterator.next();
            if (name.contains("李")){
                iterator.remove();
            }
        }
//        for (int i = 0; i < arrayList.size(); i++) {
//            String name=arrayList.get(i);
//            if (name.contains("李")){
//                arrayList.remove(i);
//                i--;
//            }
//
//        }
        System.out.println(arrayList);
    }
}
