import java.util.Scanner;

public class Algoritmus {

    
    private enum Krok {
        ZADANI,
        KONTROLA,
        VYPOCET,
        VYPIS,
        KONEC
    }

    private int zadanaHodnota;
    private int vysledek;
    private Krok aktualniKrok = Krok.ZADANI;

    public void krokZadani() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadej číslo: ");
        zadanaHodnota = sc.nextInt();
        aktualniKrok = Krok.KONTROLA;
    }

    public boolean krokKontrola() {
        if (zadanaHodnota == 0) {
            System.out.println("Zadána nula - zkus to znovu");
            aktualniKrok = Krok.KONEC; // přeskočíme na konec
            return false;
        }
        aktualniKrok = Krok.VYPOCET;
        return true;
    }

    public void krokVypocet() {
        vysledek = zadanaHodnota * 10;
        aktualniKrok = Krok.VYPIS;
    }

    public void krokVypis() {
        System.out.println("Výsledek: " + vysledek);
        aktualniKrok = Krok.KONEC;
    }

    public void krokKonec() {
        System.out.println("Konec");
    }

    public void udelejKroky() {
        while (true) {
            switch (aktualniKrok) {
                case ZADANI:
                    krokZadani();
                    break;
                case KONTROLA:
                    if (!krokKontrola()) {
                        krokKonec();
                        return;
                    }
                    break;
                case VYPOCET:
                    krokVypocet();
                    break;
                case VYPIS:
                    krokVypis();
                    break;
                case KONEC:
                    krokKonec();
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Algoritmus algoritmus = new Algoritmus();
        algoritmus.udelejKroky();
    }
}
