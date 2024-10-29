package Entity;

import java.util.Date;

public class DeliveryHistory {
	
	private int id;
	private DeliveryStatus deliveryStatus;
	private Order order;
	private Date date_time;
	
	public DeliveryHistory(int id, DeliveryStatus deliveryStatus, Order order, Date date_time) {
		this.id = id;
		this.deliveryStatus = deliveryStatus;
		this.order = order;
		this.date_time = date_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	
	
	

}
