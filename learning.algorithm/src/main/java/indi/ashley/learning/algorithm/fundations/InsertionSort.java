package indi.ashley.learning.algorithm.fundations;

import java.security.Key;
import java.util.List;

/**
 * Created by yuer5 on 16/5/19.
 */

//INSERTION-SORT.A/
//1 for j D 2 to A.length
//2     key = A[j]
//3     //Insert A[j] into the sorted sequence A[1..j - 1].
//4     i = j - 1
//5     while i > 0 and A[i] > key
//6         A[i + 1] = A[i]
//7         i = i - 1
//8     A[i + 1] = key
public class InsertionSort {

    public List<Node> Sort(List<Node> nodes){

        for(int j=1; j<nodes.size() ;j++){
            Node K = nodes.get(j);
            int i = j - 1;
            while (i >=0 && nodes.get(i).getNodeValue() > K.getNodeValue()) {
                nodes.set(i+1, nodes.get(i));
                i = i - 1;
            }
            nodes.set(i+1, K);
        }

        return nodes;
    }

}
