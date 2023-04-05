import java.util.LinkedList;
import java.util.Queue;

public class Processer {
    private Queue<Thread> WaitingQueue = new LinkedList<>();
    private Queue<Thread> ReadyQueue = new LinkedList<>();
    private Thread curr_Thread = null;
    public void toReadyQueue(Thread thread) {
        this.ReadyQueue.add(thread);
    }
    public void run() {
        int i=0; // waiting queue 로 들어가는거 구현 위함.
        try{
            while(true){
                i++;
                if (curr_Thread == null){
                    if (!ReadyQueue.isEmpty())
                        curr_Thread = ReadyQueue.poll();
                    else if (ReadyQueue.isEmpty() && !WaitingQueue.isEmpty()){
                        curr_Thread = WaitingQueue.poll();
                    }else return;
                }
                if (i ==3){
                    WaitingQueue.add(curr_Thread);
                    curr_Thread = null;
                    continue;
                }
                curr_Thread.start();
                curr_Thread.join();
                curr_Thread = null;
//                System.out.println("레디 큐 사이즈 : " + ReadyQueue.size());
//                System.out.println("웨이팅 큐 사이즈 : " + WaitingQueue.size());
//                i++;
//                if (curr_Thread != null){
//                    // waitingQueue 로 들어감을 구현하기 위함. 원래 실행 후 I/O요청을 한 후 waitingQueue로 들어가나 여기서는 간단히 구현
//                    if (i==3){
//                        this.WaitingQueue.add(curr_Thread);
//                        curr_Thread = null;
//                        continue;
//                    }
//                    curr_Thread.start();
//                    curr_Thread.join();
//                }
//                if (ReadyQueue.isEmpty()){
//                    if (WaitingQueue.isEmpty()) return;
//                    ReadyQueue.add(WaitingQueue.poll());
//                }else {
//                    curr_Thread = ReadyQueue.poll();
//                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
