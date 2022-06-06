package algorithms;

import java.util.ArrayList;
import java.util.List;


// Taken from https://www.geeksforgeeks.org/pigeonhole-sort/?ref=lbp
public class pigeonholesort extends Sorter{
    public pigeonholesort(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public void sort()
    {
        int min = numbers.get(0);
        int max = numbers.get(0);
        int range, i, j, index;

        for(int a=0; a<numbers.size(); a++)
        {
            if(numbers.get(a) > max)
                max = numbers.get(a);
            if(numbers.get(a) < min)
                min = numbers.get(a);
        }

        range = max - min + 1;
        List<Integer> phole = new ArrayList<>();
        for (int k = 0; k < range; k++) {
            phole.add(0);
        }

        for(i = 0; i<numbers.size(); i++) {
            int tmp = numbers.get(i) - min;
            phole.set(tmp, phole.get(tmp) +1);
        }


        index = 0;

        for(j = 0; j<range; j++)
            while(phole.set(j, phole.get(j) -1) > 0)
                numbers.set(index++, j+min);


    }
}
