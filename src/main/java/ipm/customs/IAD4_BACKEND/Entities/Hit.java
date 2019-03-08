package ipm.customs.IAD4_BACKEND.Entities;

import javax.persistence.*;

@Entity
@Table(name = "hit_to_graph")
public class Hit {
    @Column(name = "ID" )
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "x")
    private double x;

    @Column(name = "y")
    private double y;

    @Column(name = "r")
    private double r;

    @Column(name = "answer")
    private boolean answer;

    @Column(name = "hit_time")
    private String text;

    protected Hit(){

    }
}
