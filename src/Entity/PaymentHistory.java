package Entity;

import java.util.Date;

public class PaymentHistory {

	private int id;
	private Date payment_date;
	private PaymentMethod paymentMethod;
	private float value;
	
	public PaymentHistory(int id, Date payment_date, PaymentMethod paymentMethod, float value) {
		this.id = id;
		this.payment_date = payment_date;
		this.paymentMethod = paymentMethod;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
