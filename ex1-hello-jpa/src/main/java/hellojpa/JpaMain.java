package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //애플리케이션 로딩 시점에 하나만 만들어야 함

        EntityManager em = emf.createEntityManager(); //db커넥션을 얻어서 쿼리를 날리고 종료되는 일관적인 단위마다 em 만들어줘야 함

        EntityTransaction tx = em.getTransaction(); //트랜잭션 얻음
        tx.begin();

        try{
            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("aaaa");

            em.detach(member); //준영속상태됨 -> JPA가 관리 x
            //-> select query만 나가고 update는 x
            //em.clear() : 영속성 컨텍스트 통째로 초기화
            //em.close() : 영속성 컨텍스트 종료

            System.out.println("------");
            tx.commit();
        } catch(Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close(); //사용을 다 하고 나면 꼭 닫아줘야 함
        }

        emf.close();
    }
}
