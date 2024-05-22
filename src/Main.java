import java.util.*;

public class Main {
    public static void main(String[] args) {


//        Sukurti klasę korta
//                - Kuri gali turėti 4 skirtingas reiksmes (string) clubs (:clubs:), diamonds (:diamonds:),
//        hearts (:hearts:) and spades (:spades:)
//        Ir eilesNumeris (string)(funkcijas kuriame pagrindineje programos klasėje, ne klasėje Korta)Sukurti
//        funkciją kuri sugeneruoja kortą.
//                Sukurti funkcija kuri sugeneruoja visa kortų kaladę (be džokerio) (kortos neturi kartotis)
//        Išspausdinti visą kortų sąrašą.Sukurti funkcija išmaišyti kortas kuri sumaišo kortas random būdu.Išspausdinti visą kortų sąrašą.
//
//        Sukurti klasę - Žaidėjas kuris turi kortų masyvą arba sąrašą (asmeninis pasirinkimas) (jame 2 kortos)
//        Sukurti funkcija kuri iš sugeneruotos kortų kaladės duoda dvi atsitiktines kortas Žaidėjui
//
//        Sukurti du Žaidėjus pagal klasę Žaidėjas
//        Žaidėjams padalinti po dvi kortas
//        Sukurti funkcija kuri IšrinkLaimėtoją(Žaidėjas žaidėjas1, Žaidėjas žaidėjas2) ir grąžina žaidėją kuris laimėjo.
//                Išvesti laimėjusį žaidėją į ekraną

        String[] kortosTipas = new String[] {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
        String[] kortos = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        List<Korta> kortuKalade = new ArrayList<>();
        for(int i = 0; i < kortosTipas.length; i++){
            for(int j = 0; j < kortos.length; j++){
                kortuKalade.add(new Korta(kortosTipas[i], kortos[j]));
            }
        }
        spausdintiKalade(kortuKalade,"Nauja kortų kaladė: ");
        System.out.println();
        ismaisytiKalade(kortuKalade);
        spausdintiKalade(kortuKalade,"Išmaišyta kortų kaladė: ");
        System.out.println();

        Zaidejas zaidejas1 = null;
        Zaidejas zaidejas2 = null;
        int kiekKortu = 2;
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        do{
            System.out.println("(1)- padalinti žaidėjams kortas,");
            System.out.println("(2)- parodyti nugalėtoją, ");
            System.out.println("(0)- pabaiga");
            choice = scanner.nextLine();
            switch(choice){
                case "1":
                    zaidejas1 = new Zaidejas(generuotiKortas(kortuKalade, kiekKortu));
                    zaidejas2 = new Zaidejas(generuotiKortas(kortuKalade, kiekKortu));
                    System.out.println("Padalinta.");
                    break;
                case "2":
                    if(zaidejas1 != null && zaidejas2 != null){
                        spausdinkZaideją(zaidejas1,"Pirmo žaidėjo kortos: ");
                        spausdinkZaideją(zaidejas2,"Antro žaidėjo kortos: ");
                        isrinkNugaletoja(zaidejas1, zaidejas2);
                    } else System.out.println("Kortos dar nepadalintos.");
                    System.out.println();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas, bandykite dar kartą.");
            }
        } while (!choice.equals("0"));



    }

    public static void spausdintiKalade(List<Korta> kalade, String antraste){
        System.out.println(antraste);
        for(Korta item: kalade){
            System.out.println(item);
        }
    }

    public static void ismaisytiKalade(List<Korta> kalade){
        Collections.shuffle(kalade, new Random());
    }

    public static List<Korta> generuotiKortas(List<Korta> kalade, int kiekKortu){
        List<Korta> temp = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < kiekKortu; i++){
            int randomKorta = random.nextInt(kalade.size());
            temp.add(kalade.get(randomKorta));
        }
        return temp;
    }

    public static Zaidejas isrinkNugaletoja(Zaidejas zaidejas1, Zaidejas zaidejas2){
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < zaidejas1.getZaidejoKortos().size(); i++){
            sum1 += kortosVerte(zaidejas1.getZaidejoKortos().get(i));
        }
        for(int i = 0; i < zaidejas2.getZaidejoKortos().size(); i++){
            sum2 += kortosVerte(zaidejas2.getZaidejoKortos().get(i));
        }
        System.out.println();
        if(sum1 > sum2) {
            System.out.println("Laimėjo pirmas žaidėjas!");
            return zaidejas1;
        }
         else if (sum1 < sum2) {
             System.out.println("Laimėjo antras žaidėjas!");
             return  zaidejas2;
        }
         else {
             System.out.println("Lygiosios");
             return null;
        }


    }

    public static int kortosVerte(Korta korta){
        //int[] kortaVerte = new int[] {1,2,3,4,5,6,7,8,9,10,10,10,10,11};
        int kortaVerte = 0;
        switch(korta.getKuriKorta()){
            case "1":
                kortaVerte = 1;
                break;
            case "2":
                kortaVerte = 2;
                break;
            case "3":
                kortaVerte = 3;
                break;
            case "4":
                kortaVerte = 4;
                break;
            case "5":
                kortaVerte = 5;
                break;
            case "6":
                kortaVerte = 6;
                break;
            case "7":
                kortaVerte = 7;
                break;
            case "8":
                kortaVerte = 8;
                break;
            case "9":
                kortaVerte = 9;
                break;
            case "10":
                kortaVerte = 10;
                break;
            case "J":
                kortaVerte = 10;
                break;
            case "Q":
                kortaVerte = 10;
                break;
            case "K":
                kortaVerte = 10;
                break;
            case "A":
                kortaVerte = 11;
                break;
        }
        return kortaVerte;
    }

    public static void spausdinkZaideją(Zaidejas zaidejas, String antraste){
        System.out.println(antraste);
        for(Korta item: zaidejas.getZaidejoKortos()){
            System.out.println(item);
        }
    }


}