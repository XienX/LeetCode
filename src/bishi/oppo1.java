package bishi;

public class oppo1 {
    private static int s = 0;
    public static synchronized void changeState(int state) {
        s = state;
    }
    public static synchronized int getState() {
        return s;
    }

    public static void main(String[] args) {
        Runnable0 runnable0 = new Runnable0();
        Runnable1 runnable1 = new Runnable1();
        Runnable2 runnable2 = new Runnable2();
        new Thread(runnable0, "线程1").start();
        new Thread(runnable1, "线程1").start();
        new Thread(runnable2, "线程1").start();
    }
}

class Runnable0 implements Runnable{
    @Override
    public void run() {
        while (true)
            if (oppo1.getState() == 0) {
                System.out.println('A');
                oppo1.changeState(1);
            }
    }
}
class Runnable1 implements Runnable{
    @Override
    public void run() {
        while (true)
            if (oppo1.getState() == 1) {
                System.out.println('B');
                oppo1.changeState(2);
            }
    }
}
class Runnable2 implements Runnable{
    @Override
    public void run() {
        while (true)
            if (oppo1.getState() == 2) {
                System.out.println('C');
                oppo1.changeState(0);
            }
    }
}