package indi.ashley.learning.ml;

import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;
import org.ujmp.core.doublematrix.DoubleMatrix2D;
import org.ujmp.core.doublematrix.impl.DefaultDenseDoubleMatrix2D;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yuer5 on 16/5/23.
 */
public class AlgoGradintDescent {

    //解参数方程坐标转换
    public Matrix GetFactorsByEquations(List<GPoint> gpsGPoints, List<GPoint> picGPoints){

        if(gpsGPoints.size() != picGPoints.size() || gpsGPoints.size() == 3) {
            System.out.println("Error");
            return null;
        }

        gpsGPoints = new ArrayList<>();
        gpsGPoints.add(new GPoint(1,1));
        gpsGPoints.add(new GPoint(3,3));
        gpsGPoints.add(new GPoint(3,1));

        picGPoints = new ArrayList<>();
        picGPoints.add(new GPoint(0,0));
        picGPoints.add(new GPoint(1,1));
        picGPoints.add(new GPoint(1,0));

        Matrix aAxis = Matrix.Factory.ones(3, 3);
        Matrix xt = Matrix.Factory.ones(3, 1);
        Matrix yt = Matrix.Factory.ones(3, 1);
        for (int i=0; i<3; i++){
            aAxis.setAsDouble(picGPoints.get(i).xValue, i, 1);
            aAxis.setAsDouble(picGPoints.get(i).yValue, i, 2);
            xt.setAsDouble(gpsGPoints.get(i).xValue, i, 0);
            yt.setAsDouble(gpsGPoints.get(i).yValue, i, 0);
        }

        Matrix result1 = aAxis.solve(xt);
        Matrix result2 = aAxis.solve(yt);

        return result1;
    }

    //梯度下降坐标转换
    public Matrix GetFactorsByGradintDescent(List<GPoint> originGPoints, List<GPoint> targetGPoints){

        List<Double[]> X1 = new ArrayList<>();
        List<Double[]> X2 = new ArrayList<>();
        for (GPoint p : originGPoints){
            X1.add(new Double[]{p.xValue});
            X2.add(new Double[]{p.yValue});
        }

        List y1 = targetGPoints
                .stream()
                .map(a -> a.xValue)
                .collect(Collectors.toList());
        List y2 = targetGPoints
                .stream()
                .map(a -> a.yValue)
                .collect(Collectors.toList());

        CostFunctionArgs arg1 = GetCostFunctionArgs(X1, y1);
        CostFunctionRets ret1 = CosFunction(arg1);
        CostFunctionArgs arg2 = GetCostFunctionArgs(X2, y2);
        CostFunctionRets ret2 = CosFunction(arg2);

//        double lambda3 = 0.09 / Math.cbrt(Math.pow((ret1.grad.abs(Calculation.Ret.NEW).getMaxValue()), 2));
//        double lambda4 = 0.09 / Math.cbrt(Math.pow((ret2.grad.abs(Calculation.Ret.NEW).getMaxValue()), 2));

        double lambda1 = 0.000001;
        double lambda2 = 0.000001;

//        System.out.println( "grad: " +new java.text.DecimalFormat("#.0000000").format(ret1.grad.abs(Calculation.Ret.NEW).getMaxValue()));
//        System.out.println( "grad: " +new java.text.DecimalFormat("#.0000000").format(ret2.grad.abs(Calculation.Ret.NEW).getMaxValue()));

//        arg1.theta = arg1.theta.minus(ret1.grad.times(lambda1));
//        arg2.theta = arg2.theta.minus(ret2.grad.times(lambda2));

        for(int i=0; i<1000000; i++) {
            ret1 = CosFunction(arg1);
            arg1.theta = arg1.theta.minus(ret1.grad.times(lambda1));
            ret2 = CosFunction(arg2);
            arg2.theta = arg2.theta.minus(ret2.grad.times(lambda2));
        }

//        System.out.println( "lambda1: " +new java.text.DecimalFormat("#.0000000").format(lambda1));
//        System.out.println( "lambda2: " +new java.text.DecimalFormat("#.0000000").format(lambda2));

//        System.out.println(arg1.theta.getAsDouble(0, 0) + "\t" + arg1.theta.getAsDouble(1, 0) + "\t" +
//                arg2.theta.getAsDouble(0, 0) + "\t" + arg2.theta.getAsDouble(1, 0));
        return arg1.theta.appendVertically(Calculation.Ret.NEW, arg2.theta);
    }

    private CostFunctionArgs GetCostFunctionArgs(List<Double[]> XValues, List<Double> yValues){

        CostFunctionArgs arg = new CostFunctionArgs();

        DoubleMatrix2D X = new DefaultDenseDoubleMatrix2D(XValues.size(), XValues.get(0).length + 1);

        Matrix y = Matrix.Factory.ones(yValues.size(), 1);

        for(int i=0; i<X.getRowCount(); i++){
            X.setAsDouble(1, i, 0);
            for (int j=1; j<X.getColumnCount(); j++)
            {
                X.setAsDouble(XValues.get(i)[j-1], i, j);
            }
            y.setAsDouble(yValues.get(i), i, 0);
        }

        arg.X = X;
        arg.y = y;
        arg.theta = Matrix.Factory.zeros(X.getColumnCount(), 1);

        return arg;

    }

    private CostFunctionRets CosFunction(CostFunctionArgs args){

        Matrix X = args.X;
        Matrix y = args.y;
        Matrix theta = args.theta;

        CostFunctionRets rets = new CostFunctionRets();

        long m = y.getSize()[1];

        Matrix htheta_y = X.mtimes(theta).minus(y);

//        Matrix grad = X.mtimes(theta).minus(y).transpose().mtimes(X).transpose();
        rets.grad = (X.transpose()).mtimes(htheta_y).divide(m);
        rets.Jtheta = htheta_y.power(Calculation.Ret.NEW, 2).getValueSum()/(2*m);

        return rets;

//        m = length(y);
//        J = -(y'*log(sigmoid(X*theta)) + (1-y)'*log(1-sigmoid(X*theta)))/2m;
//        grad = X'*(X*theta-y)/m;

    }
}
