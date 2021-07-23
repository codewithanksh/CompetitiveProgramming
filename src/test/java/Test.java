public class Test {

    public static void main(String[] args) {

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        printEvenOdd(thread1,thread2,10);


    }

    public static void printEvenOdd(Thread t1, Thread t2, int nos) {
        t1.start();

        for(int i=1; i < nos; i++) {

            if(nos % 2 == 0) {
                System.out.println(i);
                t2.stop();
                t1.resume();
            }
            else {
                System.out.println(i);
                t1.stop();
                t2.resume();
            }
        }

        t1.suspend();
        t2.suspend();
    }
}
