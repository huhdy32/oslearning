public class SharedMemoryAccessThread extends Thread{

    private CriticalSection sec;
    private int data;

    public SharedMemoryAccessThread(CriticalSection sec, int data){
        this.sec =sec;
        this.data =data;
    }
    public void run(){
        while (true){
            if (sec.accessMemory(data)){
                return;
            }
        }
    }
}
