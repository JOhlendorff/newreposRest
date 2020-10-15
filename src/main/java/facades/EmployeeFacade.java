/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author jenso
 */
public class EmployeeFacade {
    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private EmployeeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Employee createEmployee(String name, String address, int salary){
        Employee employee = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        }finally {
            em.close();
        }
    }
    
    public List<Employee> getAllEmployees(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> query = 
                       em.createQuery("SELECT e FROM Employee e",Employee.class);
            return query.getResultList();
        }finally {
            em.close();
        }

    }
    
    public Employee getEmployeeByID(int id){
        EntityManager em = emf.createEntityManager();
            try{
                Employee e = em.find(Employee.class,id);
                return e;
            }
            finally{
                em.close();

        }
        
    }
    
    public List<Employee> getEmployeesByName(String name){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> query = 
                       em.createQuery("SELECT e FROM Employee e WHERE e.name =:name",Employee.class);
            query.setParameter("name", name);
            return query.getResultList();
        }finally {
            em.close();
        }
        
    }
    public List<Employee> getEmployeesByHighestSalary(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> query = 
                       em.createQuery("SELECT e FROM employee e WHERE e.salary = (SELECT MAX(e.salary) from employee e)",Employee.class);
            return query.getResultList();
        }finally {
            em.close();
        }
        
    }
    

}
