package personnages;
import personnages.Equipement;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert (force>=0);
		
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + "est deja bien protege !");
			break;
		case 1:
			if (equipement.toString().equals(this.equipements[0].toString())) {
			System.out.println("Le soldat " + this.nom + " possede deja un "+ equipement.toString() +" !");
			break;
			}
		default:
			System.out.println("Le soldat " + this.nom + " s'equipe avec un " + equipement.toString());
			this.equipements[nbEquipement] = equipement;
			nbEquipement++;
			break;
		}
		
	}
}
