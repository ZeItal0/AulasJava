package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends Base{
	
	private Date order_date;
	private float value;
	private float delivery_fee;
	private Promotion promotion;
	private PaymentMethod paymentMethod;
	private String observation;
	private float change;
	private Adress adress;
	private List<DeliveryHistory> DeliveryHistory =  new ArrayList<>();
	private List<Assessment> Assessment =  new ArrayList<>();
	private List<ProductOrder> ProductOrder =  new ArrayList<>();
	private DeliveryStatus deliveryStatus;
	
	public Order(Date order_date, float value, float delivery_fee, Promotion promotion, PaymentMethod paymentMethod,
			String observation, float change, Adress adress, List<application.DeliveryHistory> deliveryHistory,
			List<application.Assessment> assessment, List<application.ProductOrder> productOrder, DeliveryStatus deliveryStatus) {
		this.order_date = order_date;
		this.value = value;
		this.delivery_fee = delivery_fee;
		this.promotion = promotion;
		this.paymentMethod = paymentMethod;
		this.observation = observation;
		this.change = change;
		this.adress = adress;
		DeliveryHistory = deliveryHistory;
		Assessment = assessment;
		ProductOrder = productOrder;
		this.deliveryStatus = deliveryStatus;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getDelivery_fee() {
		return delivery_fee;
	}

	public void setDelivery_fee(float delivery_fee) {
		this.delivery_fee = delivery_fee;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public float getChange() {
		return change;
	}

	public void setChange(float change) {
		this.change = change;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<DeliveryHistory> getDeliveryHistory() {
		return DeliveryHistory;
	}

	public void setDeliveryHistory(List<DeliveryHistory> deliveryHistory) {
		DeliveryHistory = deliveryHistory;
	}

	public List<Assessment> getAssessment() {
		return Assessment;
	}

	public void setAssessment(List<Assessment> assessment) {
		Assessment = assessment;
	}

	public List<ProductOrder> getProductOrder() {
		return ProductOrder;
	}

	public void setProductOrder(List<ProductOrder> productOrder) {
		ProductOrder = productOrder;
	}
	public void addProductOrder (ProductOrder item) {
		this.ProductOrder.add(item);
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	
	
	

}
