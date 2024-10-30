package Entity;

import java.util.Date;

public class PaymentHistory extends Base{

	
	private Date payment_date;
	private PaymentMethod paymentMethod;
	private float value;
	
	public PaymentHistory(Date payment_date, PaymentMethod paymentMethod, float value) {
		
		this.payment_date = payment_date;
		this.paymentMethod = paymentMethod;
		this.value = value;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	
	
	
	
	
}
