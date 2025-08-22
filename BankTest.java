import java.util.ArrayList;
import lib.*;

public class BankTest {
    public static void main(String[] args) {
        BankAccount Ac1 = new BankAccount();
        ArrayList<Thread> t = new ArrayList<>();
        int NUM_DEPOSITOR = 5;
        int NUM_WITHDRAWER = 0;
        int VALUE = 100;
        int ROUND = 10000;
        int sum = 0;

        // Built Thread
        for (int i = 0; i < NUM_DEPOSITOR; i++) {
            Thread x = new Thread(new Depositor(Ac1, VALUE, ROUND)); // เก็บไว้ก่อนแต่ยังไม่ทำงาน
            t.add(x);
        }

        for (int i = 0; i < NUM_WITHDRAWER; i++) {
            Thread x = new Thread(new Withdrawer(Ac1, VALUE, ROUND)); // เก็บไว้ก่อนแต่ยังไม่ทำงาน
            t.add(x);
        }

        for (Thread thread : t) {
            thread.start(); // เริ่มทำงาน
        }

        try {
            for (Thread thread : t) {
                thread.join(); // ดูว่าทำงานเสร็จยัง
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        sum = (NUM_DEPOSITOR - NUM_WITHDRAWER)*VALUE*ROUND;

        System.out.println("Excepted Value : " + sum);
        System.out.println("Real value : " + Ac1.getBalance());
    }
}
