package algorithms;

import java.util.List;

public class combsort extends Sorter {

    public combsort(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public void sort()
    {
        int gap = numbers.size();
        boolean swapped = true;
        while (gap != 1 || swapped == false) {
            if (gap < 1)
                gap = 1;
            else
                gap = (gap * 10) / 13;

            swapped = false;

            for (int i = 0; i < numbers.size() - gap; i++) {
                if (numbers.get(i) > numbers.get(i + gap)) {
                    swap(i, i + gap);
                    swapped = true;
                }
            }
        }
    }
}
