package com.drstrange.drstrange.data;
import com.drstrange.drstrange.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class RoleRepository {
    private static SessionFactory factory;

    @Autowired
    public RoleRepository(SessionFactory factory){this.factory = factory;}

    public Role findByName(String name){
        Role role = null;
        try(Session session = factory.openSession()){
            session.beginTransaction();
            role = (Role) session.createSQLQuery("select * from roles where name = '"+name+"'").getSingleResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("fuck");
        }

        return role;
    }
}
