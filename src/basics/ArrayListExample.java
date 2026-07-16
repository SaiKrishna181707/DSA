import java.util.ArrayList;
public class ArrayListExample {
    static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(67);
        list.add(69);
        list.add(55);
        list.add(7);
        list.add(995);
        System.out.println(list);
        System.out.println(list.contains(18));
        list.set(0,99);
        System.out.println(list);
        list.remove(2);



    }
}
