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
            //비영속
/*
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
*/

            //영속
/*
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L); //영속성 컨텍스트에 있는 1차 캐시에 있는 걸 가져온다.

            System.out.println("result = " + (findMember1 == findMember2)); //영속 엔티티의 동일성 보장 -> true (1차 캐시 때문. 1차 캐시로 반복가능한 읽기)
            tx.commit();
*/

            /*Member member1 = new Member(212L, "A");
            Member member2 = new Member(121L, "B");

            em.persist(member1);
            em.persist(member2); //이때마다 다 쿼리를 날리면 최적화할 수 있는 여지가 없다 -> 한번에 보내지 않음. hibernate.jdbc.batch_size = 이 사이즈만큼 모았다가 데이터베이스에 쿼리 보냄(버퍼링 기능)

            System.out.println("=======");
*/

            Member member = em.find(Member.class, 150L);
            member.setName("zzzz"); // dirty checking(변경 감지). 이후에 em.persist(member) 해주는 것 x

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
