package tread.control;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }
    static class CheckedRunnable implements Runnable {
        @Override
        public void run() {

        }
    }
}
