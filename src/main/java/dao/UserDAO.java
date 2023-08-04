package dao;

import model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em){
        this.em = em;
    }

    public void createUser(User newUser){
        this.em.persist(newUser);
    }

    public void updateUser(User user){
        this.em.merge(user);
    }

    public void deleteUser(User user){
        user=this.em.merge(user);
        this.em.remove(user);
    }

    public User getUserById(Long userId){
        return this.em.find(User.class,userId);
    }

    public List<User> getUsers(){
        String jpql="SELECT u FROM User AS u";
        return this.em.createQuery(jpql,User.class).getResultList();
    }

    public List<User> getUsersByNamePosition(String name){
        String jpql="SELECT u FROM User AS u WHERE u.position.name=:name";
        return this.em.createQuery(jpql,User.class).setParameter("name",name).getResultList();
    }
}
