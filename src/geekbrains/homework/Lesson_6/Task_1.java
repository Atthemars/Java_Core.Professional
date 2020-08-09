package geekbrains.homework.Lesson_6;

import java.util.Arrays;

public class Task_1 {
//    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Task_1.class);

    public static void main(String[] args) {
        final int[] res2 = process(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(res2);
    }

    public static int[] process(int[] arrIn) {
        int[] backArr;
        if(arrIn.length == 0) {
//            log.info("В массиве нет элементов");
            return arrIn;
        }
        for (int i = 0; i < arrIn.length; ++i) {
            if(arrIn[i] == 4) {
                backArr = Arrays.copyOfRange(arrIn, (i+1), arrIn.length);
                System.out.println("Result" + Arrays.toString(backArr));
                return backArr;
            }
        }
        throw new RuntimeException("В массиве нет ни одной 4-ки после которой были бы числа");
    }
}


