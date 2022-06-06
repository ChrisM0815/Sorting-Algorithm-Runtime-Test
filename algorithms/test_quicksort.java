package algorithms;

import java.util.List;

public class test_quicksort extends Sorter {


    int start;
    int stop;

    public test_quicksort(List<Integer> numbers)
    {
        super(numbers);
        this.start = 0;
        this.stop = this.numbers.size() -1;
    }

    public test_quicksort(List<Integer> numbers, int start, int stop)
    {
        super(numbers);
        this.start = start;
        this.stop = stop;
    }

    public void sort() {

        if (this.stop - this.start > 0) {
            int pivot = this.start;

            for (int i = start + 1; i <= stop; i++) {
                if (this.numbers.get(i) < this.numbers.get(pivot)) {
                    swap(pivot, pivot + 1);
                    pivot++;
                    if(i != pivot)
                        swap(pivot -1, i);
                }
            }

            test_quicksort less = new test_quicksort(this.numbers, this.start, pivot - 1);
            less.sort();
            test_quicksort more = new test_quicksort(this.numbers, pivot + 1, this.stop);
            more.sort();

        }
    }

}