package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Jpa 사용하는 애라는 걸 인식
public class Member {

    @Id //pk
    private Long id;
    private String name;

    //jpa는 동적으로 객체 생성을 해야하기 때문에 항상 기본생성자가 있어야 함
    public Member() {}

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
