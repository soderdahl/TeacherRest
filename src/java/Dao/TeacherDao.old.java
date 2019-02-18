
package Dao;

import entity.Teacher;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TeacherDao {
    
    @PersistenceContext(name="TeacherRestPU")
    EntityManager em;
    
    public void addTeacher(Teacher t){
        em.persist(t);
    }
    
    public void editTeacher(Teacher t){
        em.merge(t);
    }
    
   
    public void removeTeacher2(Integer id){  
        
        em.remove(em.find(Teacher.class,id));
    }
    
    public Teacher findById(Integer id){
        return em.find(Teacher.class, id);
    }
    
    public List<Teacher> findAll(){
        return em.createQuery("Select t from Teacher t").getResultList();
    }
    
    
    
}
