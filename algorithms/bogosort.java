package algorithms;


import java.util.List;
import java.util.Random;

public class bogosort extends Sorter{

    public bogosort(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public void sort() {
        Random rand = new Random();
        while(!isSorted())
        {
            int a = rand.nextInt(numbers.size());
            int b = rand.nextInt(numbers.size());

            this.swap(a,b);
        }
    }

}
