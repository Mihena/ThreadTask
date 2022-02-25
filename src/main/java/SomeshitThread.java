public class SomeshitThread extends Thread{

    private int N;
    private long answer = 1;

    public long getAnswer() {
       return this.answer;
    }

    SomeshitThread(int N) {
        this.N = N;
    }

    @Override
    public void run() {
        for (int i = 0; i < N; i++) {
            answer-=i;
        }
        Logger.log(getClass().getName()+": "+answer);
    }
}
