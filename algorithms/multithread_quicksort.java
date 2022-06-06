package algorithms;

import java.util.ArrayList;
import java.util.List;

public class multithread_quicksort extends Sorter implements Runnable{

    List<Integer> lessList;
    List<Integer> moreList;
    List<Integer> sortedList;
    int thread_count;
    int MAX_THREADS;

    public multithread_quicksort(List<Integer> numbers, int thread_count) {
        super(numbers);
        this.MAX_THREADS = (int) Math.log10(numbers.size());
        this.thread_count = thread_count;
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
            if(this.thread_count + 2 <= this.MAX_THREADS)
            {
                this.thread_count +=2;
                Thread lessThread = new Thread(new multithread_quicksort(lessList, this.thread_count));
                Thread moreThread = new Thread(new multithread_quicksort(moreList, this.thread_count));
                lessThread.start();
                moreThread.start();
                try {
                    lessThread.join();
                    moreThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.thread_count -=2;
            }
            else
            {
                multithread_quicksort less = new multithread_quicksort(lessList, this.thread_count);
                less.sort();
                multithread_quicksort more = new multithread_quicksort(moreList, this.thread_count);
                more.sort();
            }

            this.numbers.clear();
            this.numbers.addAll(this.lessList);
            this.numbers.addAll(this.sortedList);
            this.numbers.addAll(this.moreList);
        }
    }

    @Override
    public void run() {
        this.sort();
    }
}
