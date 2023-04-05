public class CriticalSection {
    private int[][] memory = new int[100][100];
    private boolean using = false;
    private int curr_Thread;



    private void setMemory(int data) {
        for (int i=0; i < memory.length; i++)
            for (int k=0; k < memory.length; k++)
                memory[i][k] = data;
    }
    private boolean Using(){
        return using;
    }
    public boolean accessMemory(int data){
        if (!Using()){
            this.using = true;
            System.out.println("메모리 수정 시작 : " + data);

            curr_Thread = data;
            this.setMemory(data);

            System.out.println("Memory access successed : " + data );
            this.using = false;

            return true;
        }
        else {
            System.out.println("현재 " + curr_Thread + " 쓰레드(프로세서)가 메모리를 사용중입니다" );
            return false;
        }
    }


    public void showMemory() {
        for (int i=0; i < memory.length; i++){
            for (int k=0; k< memory[0].length; k++){
                System.out.print(memory[i][k]);
            }
            System.out.println();
        }
    }

}
