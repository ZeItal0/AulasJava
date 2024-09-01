package Tasks;

public class Object {

	public static void main(String[] args) {
		Functions bucket = new Functions();
		bucket.Situation = "The bucket is empty";
		bucket.Capacity = 64.31;
		bucket.AmontOfWater = 0;
		double amountSum;
		
		
		amountSum = bucket.addWater(bucket.AmontOfWater);
		amountSum = bucket.addWater(bucket.AmontOfWater);
		bucket.TotalQuantity();
		bucket.TotalQuantity();
		System.out.printf("Bucket contains %.2fL%n", amountSum);
		
		
		String amountSituation = bucket.Verification(bucket.Situation);
		System.out.println(amountSituation);
		
		bucket.bucketSize();
		bucket.bucketColor();
		bucket.emptyBucket();
		
		
	}

}
