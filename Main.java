public class Main {
    public static void main(String[] args) {


        CriticalSection sec1 = new CriticalSection();


        Thread temp1 = new SharedMemoryAccessThread(sec1, 1);
        Thread temp2 = new SharedMemoryAccessThread(sec1, 2);
        Thread temp3 = new SharedMemoryAccessThread(sec1, 3);

        temp3.start();
        temp2.start();
        temp1.start();

        try {
            temp1.join();
            temp2.join();
            temp3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sec1.showMemory();
        System.out.println("Main Thread Terminated");
    }
}




