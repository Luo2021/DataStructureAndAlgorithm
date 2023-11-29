package luo.li.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @Author liluo
 * @create 2023/10/23 10:00
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"国\t被灭 ");
                countDownLatch.countDown();
            },CountryEnum.forEachEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println("秦国 \t一统天下  ");
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 号同学离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 同学走完班长关门");
    }
}

enum  CountryEnum {
    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"韩"),
    FIVE(5,"赵"),
    SIX(6,"魏");
    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public static CountryEnum forEachEnum(int index){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if (index==value.getRetCode()){
                return value;
            }
        }
        return null;
    }
}
