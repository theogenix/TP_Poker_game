import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Paquet {
    public ArrayList<Carte> paquet;
    public String nom;
    public Paquet() {
        paquet = new ArrayList<Carte>();
        for (Valeur v : Valeur.values()) {
            for (Couleur c : Couleur.values()) {
                Carte carte = new Carte(c, v);
                this.paquet.add(carte);
            }
        }
    }
    @Override
    public String toString() {
        return String.valueOf(this.paquet);
    }
    public void shuffle(){
        Collections.shuffle(this.paquet);
    }
    public void sort(){
        Collections.sort(this.paquet, new CarteComparator());
    }
    public void distribute(Joueur joueur1){
        joueur1.main_de_depart.add(this.paquet.remove(0));
    }
    public void victoire(Joueur joueur1){

    }
}

