package threadpractice;

public class Account {
    //잔액(balance)
    private int balance = 1000;
    public int getBalance() {
        return balance;
    }
    //인출 성공 시 true, 실패 시 false 반환하는 메서드
    public boolean withdraw(int money){
        if(balance>=money){
            //if문 실행부에 진입하자마자 해당 시레드를 일시정지 시키고 다른 스레드에게 제어권을 강제로 넘긴다(의도된 문제상황)
            try{Thread.sleep(1000);} catch(Exception error){};
            //인출 계산
            balance -= money;
            return true;
        }
        return false;
    }
    //문제 해결 1. 메서드 전체를 임계 영역으로 지정한다
    /*
        public synchronized boolean withdraw(int money){
        if(balance>=money){
            //if문 실행부에 진입하자마자 해당 시레드를 일시정지 시키고 다른 스레드에게 제어권을 강제로 넘긴다(의도된 문제상황)
            try{Thread.sleep(1000);} catch(Exception error){};
            //인출 계산
            balance -= money;
            return true;
        }
        return false;
    }
    */
    //문제 해결 2. 특정 영역을 임계 영역으로 지정한다
    /*
        public boolean withdraw(int money){
            synchronized(this){
                if(balance>=money){
                    try{Thread.sleep(1000);} catch(Exception error){};
                    balance -= money;
                    return true;
                }
                return false;
            }
        }
    */

}
