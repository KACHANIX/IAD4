package ipm.customs.IAD4_BACKEND.Entities;

import javax.persistence.*;

@Entity
@Table(name = "hit_to_graph")
public class Hit {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(name = "x")
    public double x;

    @Column(name = "y")
    public double y;

    @Column(name = "r")
    public double r;

    @Column(name = "answer")
    public boolean answer;

    @Column(name = "hit_time")
    public String hit_time;

    @ManyToOne
    @JoinColumn(name = "usr_username")
    public User uUsr;

    protected Hit() {
    }
}
