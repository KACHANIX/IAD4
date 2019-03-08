package ipm.customs.IAD4_BACKEND.Entities;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Column(name = "ID")
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private  String password;
}
