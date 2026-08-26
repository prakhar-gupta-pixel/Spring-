package in.strikes.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

//    @Value("${paymentGateway.type}")
//    private String type;
//
//    public PaymentGateway(@Value("${paymentGateway.type:Razorpay}") String type,
//                          @Value("${paymentGateway.retry-count:3}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }
//
////    @Value("${paymentGateway.retry-count}")
//    private int retryCount;
//


    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }


    public String getType() {
        return paymentProperties.getType();
    }
    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }
    public int getTimeout() {
        return paymentProperties.getTimeout();
    }
    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }

    public void print() {
        System.out.println(paymentProperties.getType());
        System.out.println(paymentProperties.getRetryCount());
        System.out.println(paymentProperties.getTimeout());
        System.out.println(paymentProperties.isEnabled());
    }
}


//    public void setType(String type) {
//        this.type = type;
//    }
//

//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }