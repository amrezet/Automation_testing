package Collections;

import java.util.*;

public class main {
    public static void main(String[] args) {

        //Set

        Set<Integer> set =new HashSet<>();

        set.add(1);
        set.add(2);

        for (int i :set){
            System.out.println(i);
        }


        //List

        List<Integer> integers= new ArrayList<>();
        integers .add(0 , 5);
        integers .add(1 , 5);
        integers .add(2 , 5);
        integers .add(3 , 777);
        integers .add(4 , 5);
        integers.add(10);

        for (int i : integers){
            System.out.println(i);
        }
        System.out.println(integers.get(3));

        //ArrayList

        ArrayList<Integer> arrayList =new ArrayList<>();

        arrayList .add(1);
        arrayList .add(6);
        arrayList .add(4);
        arrayList .add(5);
        arrayList .add(10);

        System.out.println(arrayList.contains(5));

        // HashMap

        HashMap<String,Integer> stringIntegerHashMap =new HashMap<>();

        stringIntegerHashMap.put("amr",10);
        stringIntegerHashMap.put("ezat",100);

        System.out.println(stringIntegerHashMap .get("amr"));
    }
}
