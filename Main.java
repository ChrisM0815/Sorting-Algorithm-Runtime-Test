import algorithms.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner read = new Scanner(System.in);

        System.out.println("How many Numbers do you want to sort?");
        int number_count = read.nextInt();
        System.out.println("Allow duplicate numbers?(y)");
        boolean allowDuplicate = read.hasNext("y");

        if (allowDuplicate)
            initializeList(numbers, number_count);
        else
            initializeListUnique(numbers, number_count);

        System.out.println("======Start Testing=====");

        testSort(new Sorter(cloneList(numbers)));
        testSort(new bucketsort(cloneList(numbers)));
        testSort(new quicksort(cloneList(numbers)));
        testSort(new test_quicksort(cloneList(numbers)));
        testSort(new multithread_quicksort(cloneList(numbers),0));
        testSort(new shellsort(cloneList(numbers)));
        testSort(new pigeonholesort(cloneList(numbers)));
        testSort(new bubblesort(cloneList(numbers)));
        testSort(new bogosort(cloneList(numbers)));

    }


    static public void testSort(Sorter sorter)
    {
        System.out.println("Sorting with "+sorter.getClass().getName().replace("algorithms.",""));

        long time = System.currentTimeMillis();
        sorter.sort();
        time = System.currentTimeMillis() - time;
        System.out.println("Sorted correctly?:"+sorter.isSorted());
        System.out.println("Finished after "+time+" milliseconds\n");

    }



    static public List<Integer> cloneList(List<Integer> list)
    {
        return new ArrayList<>(list);
    }

    static public void initializeList(List<Integer> list, int size){
        Random rand = new Random();
        while (list.size() < size)
        {
            list.add(rand.nextInt(size + 1));
        }
    }

    static public void initializeListUnique(List<Integer> list, int size){
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        for (int i = 0; i < size; i++) {
            int random = rand.nextInt(size);
            int tmp = list.get(i);
            list.set(i,list.get(random));
            list.set(random,tmp);
        }
    }

}
