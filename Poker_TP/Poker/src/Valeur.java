public enum Valeur {
    deux(2), trois(3), quatre(4), cinq(5), six(6), sept(7), huit(8), neuf(9), dix(10), valet(11), reine(12), roi(13), as(14);
    private int valeur;
    Valeur(int valeur){
        this.valeur=valeur;
    }
    public int getValeur() {
        return (int) valeur;
    }
}
