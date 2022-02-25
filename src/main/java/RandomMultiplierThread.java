public class RandomMultiplierThread extends Thread {

    private int N;
    private long answer = 1;

    public long getAnswer() {
        return this.answer;
    }

    RandomMultiplierThread(int N) {
        this.N = N;
    }

    @Override
    public void run() {
        for (int i = 1; i < N; i++) {
            if(Math.random() < 0.5) {
                answer*=i;
            }
        }
        Logger.log(getClass().getName()+": "+answer);
    }
}
