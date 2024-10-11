package Lab;

import java.util.ArrayList;
import java.util.List;
public class MyArrayList {
    public static void main(String[] args) {
        List<String> names = new ArrayList();
        names.add("Tom");
        names.add("Lilly");
        names.add("Oksana");
        names.add("Pierce");
        names.add(4,"Mandy");
        //Mandy placed at index4 which is the last word in array list
        //output Tom, Lilly, Oksana, Pierce, Mandy
//output the contents of the list
        for (int i = 0; i < names.size(); i++){
            String name = names.get(i);
            System.out.println(name);
        }
    }
}

