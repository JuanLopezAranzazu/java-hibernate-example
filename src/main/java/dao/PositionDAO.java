package dao;

import model.Position;

import javax.persistence.EntityManager;
import java.util.List;

public class PositionDAO {
    private EntityManager em;

    public PositionDAO(EntityManager em){
        this.em = em;
    }

    public void createPosition(Position newPosition){
        this.em.persist(newPosition);
    }

    public void updatePosition(Position position){
        this.em.merge(position);
    }

    public void deletePosition(Position position){
        position=this.em.merge(position);
        this.em.remove(position);
    }

    public Position getPositionById(Long positionId){
        return this.em.find(Position.class,positionId);
    }

    public List<Position> getPositions(){
        String jpql="SELECT p FROM Position AS p";
        return this.em.createQuery(jpql,Position.class).getResultList();
    }
}
