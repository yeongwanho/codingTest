package tread.executor.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class OldOrderService {
    public void order(String orderNo) throws Exception {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Boolean> inventoryFuture = es.submit(inventoryWork);
        Future<Boolean> shippinFuture = es.submit(shippingWork);
        Future<Boolean> accountFuture = es.submit(accountingWork);
        boolean inventoryCall = inventoryFuture.get();
        boolean shippingCall = shippinFuture.get();
        boolean accountingCall = accountFuture.get();
        if (inventoryCall && shippingCall && accountingCall){
            log(" 모든 주문 처리가 성공적으로 완료 되었습니다.");
        }else {
            log("일부 작업이 실패 했습니다.");
        }
    }

    static class ShippingWork implements Callable<Boolean> {

        private String orderNo;

        public ShippingWork(String orderNo){
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() throws Exception {
            log("배송 시스템 알림 : " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class AccountingWork implements Callable<Boolean>{
        private String orderNo;
        public AccountingWork(String orderNo){
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() throws Exception {
            log("회계 시스템 업데이트: "+ orderNo);
            sleep(1000);
            return true;
        }
    }

    static class InventoryWork implements Callable<Boolean> {

        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call(){
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
