package Entity;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethod extends Base{

	private String shape;
	private List<PaymentHistory> paymentHistory = new ArrayList<>();
	private List<Order> order =  new ArrayList<>();
	
	public PaymentMethod(String shape, List<PaymentHistory> paymentHistory, List<Order> order) {
		this.shape = shape;
		this.paymentHistory = paymentHistory;
		this.order = order;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public List<PaymentHistory> getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(List<PaymentHistory> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
	
	
	
}
