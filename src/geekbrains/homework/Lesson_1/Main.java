package geekbrains.homework.Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /**
         * Задание 1
         * Написать метод, который меняет два элемента массива местами.
         * (массив может быть любого ссылочного типа);
         */
        Integer[] array = new Integer[3];
        array[0] = 2019;
        array[1] = 07;
        array[2] = 25;
        System.out.println("Массив" + Arrays.toString(array));
        replaceElements(array, 0, 2); //смена элементов местами
        System.out.println("Поменяем 1й и 3й элементы массива местами: " + Arrays.toString(array));
        /**
         * Задание 2
         * Написать метод, который преобразует массив в ArrayList;
         */
        ArrayList<Integer> arrayList = arrToArrayList(array);

        /**
         * Задание 3
         * Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
         * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
         * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
         * Для хранения фруктов внутри коробки можно использовать ArrayList;
         * Сделать метод getWeight(), который высчитывает вес коробки,
         * зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
         * Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
         * которую подадут в compare в качестве параметра, true – если она равны по весу,
         * false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
         * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
         * (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
         * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
         * Не забываем про метод добавления фрукта в коробку.
         */
        Apple appleA = new Apple();
        Apple appleB = new Apple();
        Apple appleC = new Apple();

        Orange orangeA = new Orange();
        Orange orangeB = new Orange();
        Orange orangeC = new Orange();
        Orange orangeD = new Orange();

        Box<Apple> box1 = new Box<Apple>(appleA,appleB);
        Box<Orange> box2 = new Box<Orange>(orangeA,orangeB,orangeC,orangeD);
        box1.add(appleC); // добавляем в ящик яблоко через метод
        box2.remove(orangeA); //удаляем из ящика апельсин orange1


        System.out.println("сравним вес коробки с яблоками и коробки с апельсинами:");
        System.out.println(box1.compareWeight(box2));
        if(box1.compareWeight(box2)) {
            System.out.println("Коробки равны по весу");
        } else System.out.println("Коробки не равны по весу");

        Box<Apple> box3 = new Box<Apple>();
        box1.replaceToAnotherBox(box3);
        System.out.println("Пересыпали яблоки в новую коробку под яблоки");
    }


    private static void replaceElements(Object[] _array, int num1, int num2) {
        Object t = _array[num1];
        _array[num1] = _array[num2];
        _array[num2] = t;
    }

    private static <T> ArrayList<T> arrToArrayList(T[] _array) {
        return new ArrayList<T>(Arrays.asList(_array));
    }
}

