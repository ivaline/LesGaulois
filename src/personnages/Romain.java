package personnages;
import personnages.Equipement;


public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	private String texte;
	
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
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		if (force > 0) {
			parler("Aïe");
		} 
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		 }
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon equipement sa force est diminue de ";
			for (int i = 0; i < nbEquipement;) {
				if (equipements[i] != null &&
					equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
				} 
				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	public int getForce() {
		return force;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
			}

		}



