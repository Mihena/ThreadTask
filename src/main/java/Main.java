import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        new Logger("log.txt");

        int N;
        while (true) {
            try {
                N = Integer.parseInt(reader.readLine());
                if(N > 0) break; else {
                    System.out.println("Введённое число должно быть больше 0");
                    Logger.log("Введено число меньше 0\n");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ошибка, введено некоректное число");
            }
        }
        Logger.log("N = " + N);
        FibonacciThread fibonacciThread = new FibonacciThread(N);
        RandomMultiplierThread randomMultiplierThread = new RandomMultiplierThread(N);
        SomeshitThread someshitThread = new SomeshitThread(N);

        fibonacciThread.start();
        randomMultiplierThread.start();
        someshitThread.start();

        try {
            fibonacciThread.join();
            randomMultiplierThread.join();
            someshitThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long a = fibonacciThread.getAnswer();
        long b = randomMultiplierThread.getAnswer();
        long c = someshitThread.getAnswer();

        long D = b*b-4*a*c;
        Logger.log("Discriminant: "+D);

        if(D < 0) {
            System.out.println("Корней нет");
            Logger.log("Корней нет");
        } else if(D == 0) {
            double answer = (-b/(double)(2*a));
            System.out.printf("x = %f", answer);
            Logger.log(String.format("x = %f", answer));
        } else if (D > 0) {
            double x1 = (-b+Math.sqrt(D))/(double) (2*a);
            double x2 = (-b-Math.sqrt(D))/(double) (2*a);

            System.out.printf("x1 = %f\nx2 = %f", x1,x2);
            Logger.log(String.format("x1 = %.2f", x1));
            Logger.log(String.format("x2 = %.2f", x2));
         }
        Logger.log();
    }
}
