package lt.studijos.entities;

import javax.persistence.*;

@Entity
@Table(name = "studentai")
public class Studentas {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vardas")
    private String vardas;

    @Column(name = "pavarde")
    private String pavarde;

    @Column(name = "gimimo_metai")
    private Integer gimimo_metai;

    @Column(name = "kursas")
    private String kursas;


    @Column(name = "studijuojama_kalba")
    private String studijuojama_kalba;


    public Studentas() {
    }

    public Studentas(String vardas, String pavarde, Integer gimimo_metai, String kursas,String studijuojama_kalba) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimo_metai = gimimo_metai;
        this.kursas=kursas;
        this.studijuojama_kalba = studijuojama_kalba;
    }

    public int getId() {
        return id;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public Integer getGimimo_metai() {
        return gimimo_metai;
    }
    public String getKursas() {
        return kursas;
    }

    public String getStudijuojama_kalba() {
        return studijuojama_kalba;
    }

    @Override
    public String toString() {
     return   "Studentas{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", gimimo_metai='" + gimimo_metai + '\'' +
             ", kursas'" + kursas + '\'' +
                ", studijuojama_kalba=" + studijuojama_kalba +
                '}';}

}
