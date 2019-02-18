package databaslagring;

import entity.Teacher;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TeacherDao {

    @PersistenceContext
    EntityManager em;

    public TeacherDao() {

    }

    public void add(Teacher t) {

        em.persist(t);

    }

    public void delete(int id) {

        em.remove(em.find(Teacher.class, id));

    }


    public void editTeacher(Teacher t) {

        em.merge(t);

    }

    public List<Teacher> findAll() {

        return em.createQuery("SELECT t FROM Teacher t").getResultList();
    }
    
    public Teacher findById(int id){
    
        return em.find(Teacher.class,id);
    
    } 

}
