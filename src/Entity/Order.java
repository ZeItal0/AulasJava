package Entity;

import java.util.Date;

public class Order {

	private int id;
	private Date order_date;
	private float value;
	private float delivery_fee;
	private Promotion promotion;
	private PaymentMethod paymentMethod;
	private String observations;
	private float change;
	private DeliveryStatus deliveryStatus;
	private address address;
	public Order(int id, Date order_date, float value, float delivery_fee, Promotion promotion,
			PaymentMethod paymentMethod, String observations, float change, DeliveryStatus deliveryStatus,
			Entity.address address) {
		this.id = id;
		this.order_date = order_date;
		this.value = value;
		this.delivery_fee = delivery_fee;
		this.promotion = promotion;
		this.paymentMethod = paymentMethod;
		this.observations = observations;
		this.change = change;
		this.deliveryStatus = deliveryStatus;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public address getAddress() {
		return address;
	}
	public void setAddress(address address) {
		this.address = address;
	}
	
	
	
}
