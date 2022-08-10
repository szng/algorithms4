package Exam;
/*
zoom
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list1 = new ArrayList<>();
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>();
        list1.add(1);
        list2.add(1);
        Class cl1 = ArrayList.class;
        Class cl2 = CopyOnWriteArrayList.class;
        Field field1 = cl1.getDeclaredField("elementData");
        Field field2 = cl2.getDeclaredField("array");
        field1.setAccessible(true);
        field2.setAccessible(true);
        Object obj1 = field1.get(list1);
        Object obj2 = field2.get(list2);
        list1.add(2);
        list2.add(2);
        Object obj3 = field1.get(list1);
        Object obj4 = field2.get(list2);
        System.out.println((obj1 == obj3) + ",");
        System.out.println(obj2 == obj4);
    }
}
