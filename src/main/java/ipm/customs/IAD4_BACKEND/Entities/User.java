package ipm.customs.IAD4_BACKEND.Entities;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "username", length = 20)
    public String username;

    @Column(name = "password", length = 50)
    public String password;

    protected User() {
    }
}
