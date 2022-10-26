package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
		+ effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void booster(Gaulois gaulois){
		if (gaulois.getNom() == "Obélix"){
			this.parler("Non, Obelix !... Tu n'auras pas de potion magique !"
					+" (Tu es tombe dedans étant petit)");
		}
		else {
			gaulois.boirePotion(this.forcePotion);
		}
	}
	
	public void preparerPotion() {
		Random random = new Random();
		this.forcePotion = random.nextInt(effetPotionMax - this.effetPotionMin) + this.effetPotionMin;
		if (forcePotion > 7) {
			this.parler("J'ai prepare une super potion de force : " + this.forcePotion);
		}
		else {
			this.parler("Je n'ai pas trouve tous les ingredients, "
					+" ma potion est seulement de force : " + this.forcePotion);
		}
	}
}

