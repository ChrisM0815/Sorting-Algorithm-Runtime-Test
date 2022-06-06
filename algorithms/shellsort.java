package algorithms;

import java.util.List;

public class shellsort extends Sorter {


    public shellsort(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public void sort()
    {
        for (int gap = numbers.size() / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < numbers.size(); i++) {
                int tmp = numbers.get(i);
                int j;
                for (j = i; j >= gap && numbers.get(j -gap) > tmp; j = j - gap) {
                    numbers.set(j,numbers.get(j - gap));
                }
                numbers.set(j,tmp);
            }
        }
    }
}
