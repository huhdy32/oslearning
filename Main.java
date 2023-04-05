public class Main {
    public static void main(String[] args) {
        // 단일프로세서 구현
        // 1. 프로세서 -> 실행중인 프로세스 완료 후 레디 큐 안의 쓰레드 가져와서 실행.
        // 2. 쓰레드 -> 프로그램 클래스 상속받아서 실행. 이때 프로세서에 할당. 실행중이라면 레디큐에 넣기.
        CriticalSection sec1 = new CriticalSection();
        Processer mainProcesser = new Processer();
        for (int i=0; i < 10; i ++){
            mainProcesser.toReadyQueue(new SharedMemoryAccessThread(sec1, i));
        }

        mainProcesser.run();

        System.out.println("Main Thread Terminated");


    }
}




