package Collection;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest implements Comparable<TreeSetTest>{
    private String name;
    private int age;

    public TreeSetTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TreeSetTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        TreeSetTest t1= new TreeSetTest("李白",19);
        TreeSetTest t2= new TreeSetTest("杜甫",18);
        Set<TreeSetTest> s=new TreeSet<>((o1,  o2) -> o2.getAge()-o1.getAge());
        s.add(t1);
        s.add(t2);
        System.out.println(s);
        s.forEach(ss->ss.setAge(11));
        for (TreeSetTest ss:s
             ) {
            ss.setAge(11);

        }
        System.out.println(s);
    }

    @Override
    public int compareTo(TreeSetTest o) {
        return this.age-o.age;
    }
}
