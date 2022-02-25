public class FibonacciThread extends Thread {

    private int N;
    private long answer;

    FibonacciThread(int N) {
        this.N = N;
    }

    public long getAnswer() {
        return this.answer;
    }

    @Override
    public void run() {
        int temp0 = 1;
        int temp1 = 1;
        int temp2 = 0;

        for (int i = 0; i < N; i++) {
            temp2 = temp0 + temp1;
            temp0 = temp1;
            temp1 = temp2;
        }
        answer = temp2;
        Logger.log(getClass().getName()+": "+answer);
    }
}
