package indi.ashley.learning.ml;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.ujmp.core.Matrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

import static org.junit.Assert.*;


/**
 * Created by yuer5 on 16/5/23.
 */
public class AlgoGradintDescentTest{

    AlgoGradintDescent convert;

    @Before
    public void setUp() throws Exception {
        convert = new AlgoGradintDescent();

    }
    @Test
    public void testGetFactorsByEquations() throws Exception {

        List<GPoint> gpsGPoints = new ArrayList<>();
        gpsGPoints.add(new GPoint(0, 0));
        gpsGPoints.add(new GPoint(0, 2));
        gpsGPoints.add(new GPoint(2, 0));

        List<GPoint> picGPoints = new ArrayList<>();
        picGPoints.add(new GPoint(2, 2));
        picGPoints.add(new GPoint(2, 4));
        picGPoints.add(new GPoint(4, 2));

        Matrix theta = convert.GetFactorsByEquations(picGPoints, gpsGPoints);

        List<Double> params = new ArrayList<>();
        Iterator values= theta.allValues().iterator();
        while(values.hasNext()){
            @SuppressWarnings("unchecked")
            Double val=(Double)values.next();
            params.add(val);
        }
        params.forEach(System.out::println);

        assertEquals(theta.getAsDouble(0, 0), 2.00, 0.01);
        assertEquals(theta.getAsDouble(0, 1), 1.0, 0.01);
        assertEquals(theta.getAsDouble(0, 2), 0.0, 0.01);
        assertEquals(theta.getAsDouble(1, 0), 2.0, 0.01);
        assertEquals(theta.getAsDouble(1, 1), 0.0, 0.01);
        assertEquals(theta.getAsDouble(1, 2), 1.0, 0.01);

//        assertEquals(theta.getAsDouble(0, 0), -2.00, 0.01);
//        assertEquals(theta.getAsDouble(0, 1), 1.0, 0.01);
//        assertEquals(theta.getAsDouble(1, 0), 20000.0, 0.01);
//        assertEquals(theta.getAsDouble(1, 1), 1000.0, 0.01);
    }

    @Test
    public void testGetFactorsByGradintDescent() throws Exception {

        long begin, end;
        begin = System.currentTimeMillis();
        Matrix theta = convert.GetFactorsByGradintDescent(GetOriginal(60), GetTrans(60));
        end = System.currentTimeMillis();
        System.out.println("计算耗时" + (end - begin) + "ms");

        List<Double> params = new ArrayList<>();
        Iterator values= theta.allValues().iterator();
        while(values.hasNext()){
            @SuppressWarnings("unchecked")
            Double val=(Double)values.next();
            params.add(val);
        }
        params.forEach(System.out::println);


        assertEquals(params.size(), 4);
        assertEquals(params.get(0), -2.00, 0.01);
        assertEquals(params.get(1), 1.0, 0.01);
        assertEquals(params.get(2), 20000.0, 0.01);
        assertEquals(params.get(3), 1000.0, 0.01);
    }

    public static List<GPoint> GetOriginal(int length){
        List<GPoint> points = new ArrayList<>();
        for(int i=0; i<length; i++) {
            points.add(new GPoint(i, 2*i));
        }

        return points;
    }

    public static List<GPoint> GetTrans(int length){

        List<GPoint> points = new ArrayList<>();
        for(int i=0; i<length; i++) {
            points.add(new GPoint(i-2, 2000*i+20000));
        }
        return points;
    }
}