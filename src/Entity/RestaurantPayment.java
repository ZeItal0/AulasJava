package Entity;

public class RestaurantPayment extends Base{

	private restaurant restaurant;
	private PaymentMethod paymentmethod;
	
	public RestaurantPayment(Entity.restaurant restaurant, PaymentMethod paymentmethod) {
		this.restaurant = restaurant;
		this.paymentmethod = paymentmethod;
	}

	public restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public PaymentMethod getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(PaymentMethod paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	
	
	
	
	
	
}
