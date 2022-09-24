package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity //Jpa 사용하는 애라는 걸 인식
public class Member {

    @Id //pk
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifinedDate;

    @Lob
    private String description;

//    create table Member (
//            id bigint not null,
//            age integer,
//            createdDate timestamp,
//            description clob,
//            lastModifinedDate timestamp,
//            roleType varchar(255),
//    name varchar(255),
//    primary key (id)
//    )

}
