package tread.executor.test;

public class OldOrderServiceTestMain {
    public static void main(String[] args) throws Exception {
        String orderNo = "Order#1234";
        OldOrderService orderService=new OldOrderService();
        orderService.order(orderNo);
    }
}
