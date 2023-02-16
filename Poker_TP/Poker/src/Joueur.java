import java.util.ArrayList;
import java.util.Collections;

public class Joueur extends Paquet {
    public String nom;
    public ArrayList<Carte> main_de_depart = new ArrayList<Carte>();
    public ArrayList<String> mes_couleurs = new ArrayList<String>();

    Joueur(String nom, ArrayList<Carte> main_de_depart) {
        this.nom = nom;
        this.main_de_depart = main_de_depart;
    }

    public String toString() {
        return String.valueOf(this.main_de_depart);
    }

    public void Trier_main() {
        Collections.sort(this.main_de_depart, new CarteComparator());
    }

    public void Trier_main_par_value() {
        Collections.sort(this.main_de_depart, new ValeurComparator());
    }

    public ArrayList<Carte> getMain() {
        return this.main_de_depart;
    }

    public int evaluer() {
        ArrayList<Carte> main_de_carte = this.main_de_depart;
        int counter_paire = 0;
        int counter_brelan = 0;
        int counter_quinte = 0;
        int counter_couleur = 0;
        int counter_full = 0;
        int counter_carre = 0;
        int counter_quinte_flush = 0;
        int counter_quinte_flush_royale = 0;
        int counter_hauteur = 0;
        int valeur_hauteur = 0;
        int quinte = 0;
        int couleur = 0;
        int score = 0;
        Trier_main_par_value();
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (j != k && j > k) {
                    // determiner si paire ou non//
                    //changer position +score//
                    if (main_de_carte.get(j).getValeur() == main_de_carte.get(k).getValeur()) {
                        score = 100 + main_de_carte.get(j).getValeur().getValeur();
                        counter_paire++;
                        if (counter_paire == 2) {
                            score = 200 + main_de_carte.get(3).getValeur().getValeur();
                            break;
                        }
                    }
                }
            }
        }
        // determiner si brelan ou non//
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                for (int i = 0; i < 5; i++) {
                    if (j != k && j > k && j != i && i != k && k > i) {
                        boolean bool1 = main_de_carte.get(j).getValeur() == main_de_carte.get(k).getValeur();
                        boolean bool2 = main_de_carte.get(k).getValeur() == main_de_carte.get(i).getValeur();
                        if (bool1 && bool2) {
                            score = 300 + main_de_carte.get(2).getValeur().getValeur();
                            counter_brelan++;
                        }
                    }
                }
            }
        }
        // determiner si quinte ou non//
        for (int i = 0; i < 4; i++) {
            if (main_de_carte.get(i).getValeur().getValeur() == ((main_de_carte.get(i + 1).getValeur().getValeur())) + 1) {
                counter_quinte++;
            }
        }
        if (main_de_carte.get(4).getValeur().getValeur() == 14 && main_de_carte.get(0).getValeur().getValeur() == 2 && main_de_carte.get(1).getValeur().getValeur() == 3 && main_de_carte.get(2).getValeur().getValeur() == 4 && main_de_carte.get(3).getValeur().getValeur() == 5) {
            counter_quinte = 4;
        }
        if (counter_quinte == 4) {
            quinte = counter_quinte;
            score = 400 + main_de_carte.get(4).getValeur().getValeur();
            if (main_de_carte.get(3).getValeur().getValeur() == 5) {
                score = 400 + main_de_carte.get(3).getValeur().getValeur();
            }
        }
        //determiner si Couleur ou non//
        for (int i = 0; i < 4; i++) {
            if (main_de_carte.get(i).getCouleur() == (main_de_carte.get(i + 1).getCouleur())) {
                counter_couleur++;
            }
        }
        if (counter_couleur == 4) {
            couleur = counter_couleur;
            score = 500 + main_de_carte.get(4).getValeur().getValeur();
        }
        //determiner si carre ou non//
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                for (int i = 0; i < 5; i++) {
                    for (int l = 0; l < 5; l++) {
                        if (j != k && j > k && j != i && i != k && k > i && l != j && l != i && l != k && i > l) {
                            boolean bool1 = main_de_carte.get(j).getValeur() == main_de_carte.get(k).getValeur();
                            boolean bool2 = main_de_carte.get(k).getValeur() == main_de_carte.get(i).getValeur();
                            boolean bool3 = main_de_carte.get(i).getValeur() == main_de_carte.get(l).getValeur();
                            if (bool1 && bool2 && bool3) {
                                counter_carre++;
                            }
                        }
                    }
                }
            }
        }
        if (counter_carre == 1) {
            score = 700 + main_de_carte.get(4).getValeur().getValeur();
        }
        //determiner si full ou non//
        if ((counter_brelan == 1 && counter_paire == 2 && counter_carre == 0)) {
            counter_full++;
            score = 600 + main_de_carte.get(4).getValeur().getValeur();
        }
        //determiner si Quinte flush ou non//
        if (quinte == 1 && couleur == 1) {
            counter_quinte_flush++;
            score = 800 + main_de_carte.get(4).getValeur().getValeur();
        }
        //determiner si Quinte flush royale ou non//
        if ((counter_quinte_flush == 1) && (this.main_de_depart.get(0).getValeur().getValeur() == 10)) {
            counter_quinte_flush_royale++;
            score = 900 + main_de_carte.get(4).getValeur().getValeur();
        }
        //determiner valeur hauteur//
        if (counter_paire == 0 && couleur == 0 && quinte == 0) {
            counter_hauteur++;
            score = this.main_de_depart.get(4).getValeur().getValeur();
        }
        return score;
    }
}

