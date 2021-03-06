package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try {
            Member member = new Member();
            member.setId("ID_A");
            member.setUsername("C");

            em.persist(member);

            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
