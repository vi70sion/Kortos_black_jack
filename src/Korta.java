public class Korta {
    private String kortosTipas; //spalva
    private String kuriKorta;   // nuo 1 iki tuzo

    public Korta(String kortosTipas, String kuriKorta) {
        this.kortosTipas = kortosTipas;
        this.kuriKorta = kuriKorta;
    }

    public String getKortosTipas() { return kortosTipas; }
    public String getKuriKorta() { return kuriKorta; }
    public void setKortosTipas(String kortosTipas) { this.kortosTipas = kortosTipas; }
    public void setKuriKorta(String kuriKorta) { this.kuriKorta = kuriKorta; }


    @Override
    public String toString(){
        return kortosTipas + " " + kuriKorta;
    }
}
