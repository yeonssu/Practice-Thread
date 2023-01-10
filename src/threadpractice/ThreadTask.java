package threadpractice;

import threadpractice.Account;

public class ThreadTask implements Runnable{
    Account account = new Account();
    public void run(){
        //잔액이 남아있으면
        while(account.getBalance()>0){
            //100~300사이의 인출금 랜덤 선택
            int money = (int) (Math.random()*3 +1 ) * 100;
            //withdraw를 실행시키는 동시에 인출 성공 여부를 변수에 할당
            boolean denied = !account.withdraw(money);
            //인출결과확인
            System.out.printf(
                    "Withdraw %d By %s. Balance : %d %s\n",
                    money,
                    Thread.currentThread().getName(),
                    account.getBalance(),
                    denied ? "-> DENIED" : ""
            );
        }
    }
}
