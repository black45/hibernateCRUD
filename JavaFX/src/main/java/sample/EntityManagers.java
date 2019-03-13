package sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class EntityManagers {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sweet");
    public static EntityManager em = emf.createEntityManager();

    public static void addStudent(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Write firstname and lastname?");
            String firstname = reader.readLine(), lastname = reader.readLine();
            em.getTransaction().begin();
            Student s = new Student(firstname, lastname);
            em.persist(s);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getStudentInfo(String s){
        try {
            Query query = em.createQuery("SELECT "+ s +" FROM Student");
            List<Student> result = query.getResultList();
            String res = result+" ";
            String returnableStr =  res.substring(1,res.lastIndexOf(']'));
            return returnableStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void getMetadata(){
        System.out.println(em.getMetamodel().getManagedTypes());
    }

    public static void describeDatabase(){
        try {
            Query query = em.createNativeQuery("show columns from Student");
            List<Object[]> result = query.getResultList();
            for (Object[] obj : result){
                System.out.println("field: " + obj[0]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateStudent(String firstname, String lastname,Integer id){
        try {

            Student update = em.find(Student.class,id);
            em.getTransaction().begin();
            update.setFirstname(firstname);
            update.setLastname(lastname);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void remove(Integer id){
        Student student = em.find(Student.class,id);
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    public static void createStudent(String firstname,String lastname) {
        em.getTransaction().begin();
        try {
            Student student = new Student(firstname,lastname);
            em.persist(student);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            em.getTransaction().commit();
        }
    }

}
