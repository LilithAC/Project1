import static java.lang.Math.sqrt;
import java.util.List;
import java.util.ArrayList;

public class homework_1 {
    //Write a java program to solve standard deviation:
    //Use it to check your work.  Also, why might it be wrong(?)
    public static void main(String[] args) {
        List<Double> list = List.of(19.0,21.0,35.0,18.0,37.0);
        stdDev(list);
    }
    public static void stdDev(List<Double> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        double mean = sum/(list.size() + 1);

        List<Double> devi = new ArrayList<>();
        //creates an array contain each element's deviation from the mean
        for (int i = 0; i < list.size(); i++) {
            double vari = list.get(i) - mean;
            devi.add(vari);
        }
        //squares each element in arrayList devi
        for (int i = 0; i < devi.size(); i++) {
            double square = devi.get(i)*devi.get(i);
            devi.set(i, square);
        }

        double sqsum = 0;
        //adds up each squared element in devi
        for (int i = 0; i < devi.size(); i++) {
            sqsum = sqsum + devi.get(i);
        }
        double deviation =  sqsum/list.size();

        double stdDev = sqrt(deviation);
        System.out.println(stdDev);
    }


}
