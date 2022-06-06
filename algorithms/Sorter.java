package algorithms;

import java.util.Collections;
import java.util.List;

public class Sorter {
    public List<Integer> numbers;

    public Sorter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void sort()
    {
        Collections.sort(numbers);
    }

    public void swap(int a, int b)
    {
        int tmp = numbers.get(a);
        numbers.set(a,numbers.get(b));
        numbers.set(b,tmp);
    }

    public boolean isSorted()
    {
        for (int i = 1; i < this.numbers.size(); i++) {
            if (this.numbers.get(i-1) > this.numbers.get(i))
                return false;
        }
        return true;
    }

    public void printNumbers(){
        for (int i: this.numbers) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
