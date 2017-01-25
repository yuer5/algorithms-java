package ashley.learning.algorithm.sorting;

/**
 * Created by zhaoqinzou on 2017/1/24.
 */
public class InsertionSort {
    public void Sort(Integer[] array){
        for(int i=1; i<array.length; i++){
            for(int k=i; k>0; k--){
                if(array[k]<array[k-1]){
                    int temp = array[k-1];
                    array[k-1] = array[k];
                    array[k] = temp;
                }
            };
        };
    }
}
