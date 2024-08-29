package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String file1 = "src/task2/circle.txt";
        String file2 = "src/task2/points.txt";
        showResult(file1, file2);
    }

    static void showResult (String fileCircle, String filePoints) throws IOException {
        try(BufferedReader reader1 = new BufferedReader(new FileReader(fileCircle));
            BufferedReader reader2 = new BufferedReader(new FileReader(filePoints))){
            List<String> temp = reader1.lines().toList();
            double[] centerCircle = new double[]
                    {Double.parseDouble(temp.get(0).split(" ")[0]),
                    Double.parseDouble(temp.get(0).split(" ")[1])};
            double radius = Double.parseDouble(temp.get(1));

            List<Double[]> points = new ArrayList<>();
            while(reader2.ready()){
                String[] t = reader2.readLine().split(" ");
                points.add(
                    new Double[]{Double.parseDouble(t[0]), Double.parseDouble(t[1])});
            }

            for (Double[] point: points){
                System.out.println(pointPosition(
                        centerCircle[0],centerCircle[1],
                        radius,
                        point[0],point[1]));
            }
        }
    }

    static int pointPosition(double x0, double y0,
                             double r,
                             double x, double y){
        if ((x0-x)*(x0-x) + (y0-y)*(y0-y) <= r*r){
            if ((x0-x)*(x0-x) + (y0-y)*(y0-y) == r*r)
                return 0;
            else
                return 1;
        }
        return 2;
    }


}
