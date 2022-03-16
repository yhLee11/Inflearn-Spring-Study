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
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(2)
                    .setMaxResults(5)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.name="+member.getName());
            }

        } catch (Exception e) {
            ts.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
