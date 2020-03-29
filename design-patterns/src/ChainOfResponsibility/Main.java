package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = generateArr(20);
        ABaseHandler h1 = new Handler1();
        ABaseHandler h2 = new Handler2();
        ABaseHandler h3 = new Handler3();
        ABaseHandler errorHandler = new ErrorHandler();
        h1.setNextHandler(h2);
        h2.setNextHandler(h3);
        h3.setNextHandler(errorHandler);

        for (int i = 0; i < list.size(); i++) {
            h1.handle(new Request(list.get(i)));
        }
    }

    static List<Integer> generateArr(int length) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr.add((int) (Math.random() * 10 + 10));
        }
        System.out.println(Arrays.toString(arr.toArray()));
        return arr;
    }
}
