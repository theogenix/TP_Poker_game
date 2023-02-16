import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Jeu extends Paquet {
    public void Lancer_Jeu() {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Combien de joueurs?");
        int nombre_de_joueurs;
        nombre_de_joueurs = sc.nextInt();
        String[] pseudos = new String[nombre_de_joueurs];
        Joueur[] joueurs;
        joueurs = new Joueur[nombre_de_joueurs];
        for (int i = 0; i < nombre_de_joueurs; i++) {
            Scanner sc2;
            sc2 = new Scanner(System.in);
            System.out.println("Quel est le pseudo du joueur " + i);
            pseudos[i] = sc2.nextLine();
            joueurs[i] = new Joueur(pseudos[i], new ArrayList<Carte>());
        }
        Paquet le_paquet_de_cartes = new Paquet();
        le_paquet_de_cartes.shuffle();
        System.out.println((le_paquet_de_cartes.toString()));
        int gagnant = -1;
        int scoreMax = -1;
        for (int i = 0; i < nombre_de_joueurs; i++) {
            for (int j = 0; j < 5; j++) {
                le_paquet_de_cartes.distribute(joueurs[i]);
            }
            joueurs[i].Trier_main();
            joueurs[i].getMain();
            if (joueurs[i].evaluer() > scoreMax) {
                scoreMax = joueurs[i].evaluer();
                gagnant = i;
            }
            System.out.println("la main de " + joueurs[i].nom + " est " + joueurs[i].toString());
        }
        System.out.println("Le gagnant est " + joueurs[gagnant].nom);
    }
}
