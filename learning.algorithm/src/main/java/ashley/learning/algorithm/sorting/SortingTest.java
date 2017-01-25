package ashley.learning.algorithm.sorting;

/**
 * Created by zhaoqinzou on 2017/1/24.
 */
public class SortingTest {
    public static void main(String[] args) {
        Integer[] array = {1,5,3,7,2,9,6,8,4,0};
        for(Integer intObj:array) {
            System.out.print(intObj + " ");
        };
        System.out.println("\n-----");
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.Sort(array);
        for(Integer intObj:array) {
            System.out.print(intObj + " ");
        };
    }
}
