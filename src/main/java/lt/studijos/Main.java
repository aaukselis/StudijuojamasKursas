package lt.studijos;

import lt.studijos.entities.Studentas;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("veikia");
        uzkrautiDuomenis();
        System.out.println("Gimusiu pasirinktais metais 1991 skaicius yra "+studentaiGimimoMetai(1991));
    }


    public static void uzkrautiDuomenis()
    {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            List<Studentas> list = entityManager.createQuery("from Studentas").getResultList();

            for (Studentas s : list) {
                System.out.println(s.getStudijuojama_kalba() +"  "+s.getKursas()+ "  "+s.getVardas());
            }
            System.out.println("");
            System.out.println("Listas susortintas");
            System.out.println("");
            // Comparatorius per java funkcini interfeisa
                       list.sort ( Comparator
                    .comparing ( Studentas::getStudijuojama_kalba )
                   .thenComparing ( Studentas::getKursas )
                   .thenComparing ( Studentas::getVardas ));

            for (Studentas s : list) {
                System.out.println(s.getStudijuojama_kalba() +"  "+s.getKursas()+ "  "+s.getVardas());
            }
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static int studentaiGimimoMetai( int metai){
        EntityManager entityManager = HibernateUtils.getEntityManager();
        int gimusiuKiekis = 0;
        try{
            entityManager.getTransaction().begin();
            List<Studentas> list = entityManager.createQuery("from Studentas").getResultList();
            for (Studentas s:list)
            {
              if(s.getGimimo_metai()==metai) gimusiuKiekis++;
            }
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return gimusiuKiekis;
    }


}
