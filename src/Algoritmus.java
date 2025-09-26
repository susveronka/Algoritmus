import java.util.Scanner;

public class Algoritmus {

    private int zadanaHodnota;
    private int vysledek;
    private int krok = 0;

    public void krok0() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadej číslo: ");
        zadanaHodnota = sc.nextInt();
        krok++;
    }

    public boolean krok1() {
        if (zadanaHodnota == 0) {
            System.out.println("Zadána nula. Ukončuji.");
            krok = 4; // přeskočíme rovnou na konec
            return false;
        }
        krok++;
        return true;
    }

    public void krok2() {
        vysledek = zadanaHodnota * 10;
        krok++;
    }

    public void krok3() {
        System.out.println("Výsledek: " + vysledek);
        krok++;
    }

    public void krok4() {
        System.out.println("Konec");
    }

    public void udelejKroky() {
        while (krok <= 4) {
            switch (krok) {
                case 0:
                    krok0();
                    break;
                case 1:
                    if (!krok1()) return; // pokud je zadána nula, ukonči
                    break;
                case 2:
                    krok2();
                    break;
                case 3:
                    krok3();
                    break;
                case 4:
                    krok4();
                    return;
                default:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Algoritmus algoritmus = new Algoritmus();
        algoritmus.udelejKroky();
    }
}

