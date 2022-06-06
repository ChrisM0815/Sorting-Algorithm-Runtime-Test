package algorithms;

import java.util.List;

public class bucketsort extends Sorter{

    private int maxValue;

    public bucketsort(List<Integer> numbers) {
        super(numbers);
        findMaxValue();
    }

    @Override
    public void sort(){
        int[] buckets = new int[this.maxValue + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = 0;
        }

        for (int i = 0; i < this.numbers.size(); i++) {
            buckets[this.numbers.get(i)]++;
        }

        int outPos = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                this.numbers.set(outPos++,i);
            }
        }
    }

    private void findMaxValue(){
        this.maxValue = this.numbers.get(0);
        for (int i:this.numbers) {
            if (i > this.maxValue)
                this.maxValue = i;
        }
    }


}
