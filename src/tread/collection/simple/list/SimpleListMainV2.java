package tread.collection.simple.list;

import static util.MyLogger.log;

public class SimpleListMainV2 {
    public static void main(String[] args) throws InterruptedException {
//        test(new SyncList());
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        //A를 리스트에 저장하는 코드
        Runnable addA = () -> {
            list.add("A");
            log("Thread - 1: list.add(A)");
        };
        //B를 리스트에 저장하는 코드
        Runnable addB = () -> {
            list.add("B");
            log("Thread - 2: list.add(B)");
        };
        Thread thread = new Thread(addA);
        Thread thread2 = new Thread(addB);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();
        log(list);
    }

}
