package by.teachmeskills.homework.hw_17022023;

public class FourthTask {
    public static void main(String[] args) {
        double[] vec = {-1.12, 20, -50, -7.34, -9, 100, 2};
        double min = vec[0];
        double max = vec[0];
        double sum = 0;
        double product = 1;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] < 0) {
                sum += vec[i];
            }
        }
        System.out.println("The sum of negative elements : " + sum);

        for (int i = 0; i < vec.length; i++) {
            if (vec[i] > max) {
                max = vec[i];
                maxIndex = i;
            }
            if (vec[i] < min) {
                min = vec[i];
                minIndex = i;
            }
        }
        if (maxIndex > minIndex) {
            for (int i = minIndex + 1; i < maxIndex; i++) {
                product *= vec[i];
            }
            System.out.println("The product of numbers : " + product);
        } else {
            for (int i = minIndex - 1; i > maxIndex; i--) {
                product *= vec[i];
            }
            System.out.println("The product of numbers : " + product);
        }

    }
}
