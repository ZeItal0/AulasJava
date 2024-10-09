package TasksPOO;

public class Functions {
	String Color;
	String Size;
	String Situation;
	double Capacity;
	double AmontOfWater;
	
	double addWater (double addedWater) {
		AmontOfWater = addedWater + 1;
		return AmontOfWater;
	}
	void TotalQuantity () {
		Capacity = Capacity - 1;
	}
	String Verification (String toKnow ) {
		Situation = "Bucket contains water";
		return Situation;
	}
	void emptyBucket () {
		AmontOfWater = 0;
	}
	void bucketSize () {
		Size = "91cm";
	}
	void bucketColor () {
		Color = "Blue";
	}
}