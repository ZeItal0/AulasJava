package TasksPOO;

public class Rpg {

	double level;
	double strength;
	double speed;
	double vitality;
	double luck;
	double stamina;
	double intelligence;
	double Defense;
	
	public Rpg(double level) {
		this.level = level;
	}
	
	public Rpg(double strength, double speed, double intelligence) {
		this.strength = strength;
		this.speed = speed;
		this.intelligence = intelligence;
		
	}
	
	public Rpg(double vitality, double luck) {
		this.vitality = vitality;
		this.luck = luck;
		
	}
	
	void ReadBook() {
		intelligence++;
	}
	void ToTrain() {
		strength++;
	}
	void Defend() {
		Defense++;
	}
	void Run() {
		speed++;
	}
	void Attack() {
		vitality++;
	}
	void LevelUp() {
		level++;
	}
	void TakePotion() {
		stamina++;
	}
	
	
	
	
	
	
}
