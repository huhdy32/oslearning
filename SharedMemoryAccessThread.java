import java.util.Queue;

public class SharedMemoryAccessThread extends Thread{

    public CriticalSection sec;
    private int data;

    public SharedMemoryAccessThread(CriticalSection sec, int data){
        this.sec =sec;
        this.data =data;
    }
    public int getData() {
        return this.data;
    }
    public void run(){
        while (true){
            if (sec.accessMemory(data)){
                return;
            }
        }
    }
}
