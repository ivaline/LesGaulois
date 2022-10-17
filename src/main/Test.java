package main;
import personnages.Chef;
import personnages.Gaulois;
import politique.Village;
import personnages.Romain;
import personnages.Equipement;

public class Test {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		asterix.parler("Salut");
		Romain minus = new Romain("Minus", 6);
		Village village = new Village("Village des Irréductibles",30);
		village.ajouterHabitant(asterix);
		//Gaulois gaulois = village.trouverHabitant(0);
		//Тип галуа и деревни разный астерикс!=галуа
		Chef abraracourcix = new Chef("Abraracourcix",6,10,village);
		village.setChef(abraracourcix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//Тоже самое, что и в первый раз. Разные типы для функции
		//System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		//village.afficherVillageois();
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		
	}
	

}
