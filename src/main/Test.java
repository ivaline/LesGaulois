package main;
import personnages.Chef;
import personnages.Gaulois;
import politique.Village;

public class Test {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		asterix.parler("Salut");
		Village village = new Village("Village des Irréductibles",30);
		village.ajouterHabitant(asterix);
		//Gaulois gaulois = village.trouverHabitant(0);
		//Тип галуа и деревни разный астерикс!=галуа
		Chef abraracourcix = new Chef("Abraracourcix",6,10,village);
		village.setChef(abraracourcix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//Тоже самое, что и в первый раз. Разные типы для функции
		//System.out.println(gaulois);
		village.afficherVillageois();
	}
	

}
