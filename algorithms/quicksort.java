package algorithms;

import java.util.ArrayList;
import java.util.List;

public class quicksort extends Sorter {

    List<Integer> lessList;
    List<Integer> moreList;
    List<Integer> sortedList;

    public quicksort(List<Integer> numbers) {
        super(numbers);
        this.lessList = new ArrayList<>();
        this.moreList = new ArrayList<>();
        this.sortedList = new ArrayList<>();
    }

    public void sort() {

        if (this.numbers.size() > 1) {
            int pivot = this.numbers.size() / 2;

            for (Integer i : this.numbers) {
                if (i > this.numbers.get(pivot))
                    moreList.add(i);
                else if (i < this.numbers.get(pivot))
                    lessList.add(i);
                else
                    sortedList.add(i);
            }
            quicksort less = new quicksort(lessList);
            less.sort();
            quicksort more = new quicksort(moreList);
            more.sort();
            this.numbers.clear();
            this.numbers.addAll(less.numbers);
            this.numbers.addAll(this.sortedList);
            this.numbers.addAll(more.numbers);
        }
    }
}
