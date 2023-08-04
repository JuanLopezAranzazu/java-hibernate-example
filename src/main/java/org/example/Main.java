package org.example;

import dao.PositionDAO;
import dao.UserDAO;
import model.Position;
import model.User;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Position newPosition=new Position("position1");
        User newUser=new User("user1","user1",newPosition);
        User newUser2=new User("user2","user2",newPosition);

        EntityManager em = new JPAUtils().getEntityManager();
        em.getTransaction().begin();

        PositionDAO positionDAO=new PositionDAO(em);
        positionDAO.createPosition(newPosition);

        UserDAO userDAO=new UserDAO(em);
        userDAO.createUser(newUser);
        userDAO.createUser(newUser2);

        System.out.println("Iniciando consultas");

        /*User user=userDAO.getUserById(1l);
        System.out.println(user.getFirstName()+" "+user.getLastName());*/

        /*List<User> data=userDAO.getUsers();
        data.forEach(user -> System.out.println(user.getFirstName()+" "+user.getLastName()));*/

        /*List<User> data=userDAO.getUsersByNamePosition("position1");
        data.forEach(user -> System.out.println(user.getFirstName()+" "+user.getLastName()));*/

        List<Position> data=positionDAO.getPositions();
        data.forEach(position -> {
            System.out.println(position.getName());
        });

        em.getTransaction().commit();
        em.close();
    }
}