package Entity;

import java.util.Date;

public class DeliveryHistory extends Base{
	
	private Order order;
	private Date date_time;
	
	public DeliveryHistory(Order order, Date date_time) {
		this.order = order;
		this.date_time = date_time;
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
