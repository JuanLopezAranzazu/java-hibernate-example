package model;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;
    private String name;

    public Position(){}

    public Position(String name) {
        this.name = name;
    }

    public Long getPositionId() {
        return positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
