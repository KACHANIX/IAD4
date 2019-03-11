package ipm.customs.IAD4_BACKEND.Entities;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue
    public int id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    protected User() {
    }
}
