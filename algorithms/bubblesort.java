package algorithms;

import java.util.List;

public class bubblesort extends Sorter {

    public bubblesort(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public void sort()
    {
        boolean noswap;
        for (int i = 0; i < numbers.size() -1; i++) {
            noswap = true;
            for (int j = 0; j < numbers.size() - i -1; j++) {
                if (this.numbers.get(j + 1) < this.numbers.get(j)) {
                    swap( j,j+1);
                    noswap = false;
                }

            }
            if (noswap)
                break;
        }
    }
}
