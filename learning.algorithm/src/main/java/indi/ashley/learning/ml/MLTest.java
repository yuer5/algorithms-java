package indi.ashley.learning.ml;

import indi.ashley.learning.algorithm.graph.dijkstra.AlgDijkstra;
import org.ujmp.core.Matrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yuer5 on 16/5/23.
 */
public class MLTest {

    public static void main(String[] args) {

        long begin, end;
        AlgoGradintDescent convert = new AlgoGradintDescent();
        begin = System.currentTimeMillis();
        Matrix theta = convert.GetFactorsByGradintDescent(GetOriginal(), GetTrans());
        theta.allValues();

        end = System.currentTimeMillis();
        System.out.println("计算耗时" + (end - begin) + "ms");

        Iterator values= theta.allValues().iterator();
        while(values.hasNext()){
            Double val=(Double)values.next();
            System.out.println(val);
        }
    }

    public static List<GPoint> GetOriginal(){
        List<GPoint> points = new ArrayList<>();
        for(int i=0; i<60; i++) {
            points.add(new GPoint(i, 2*i));
        }

        return points;
    }

    public static List<GPoint> GetTrans(){

        List<GPoint> points = new ArrayList<>();
        for(int i=0; i<60; i++) {
            points.add(new GPoint(i-2, 2000*i+20000));
        }
        return points;
    }
}
