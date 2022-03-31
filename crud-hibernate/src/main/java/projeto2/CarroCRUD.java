package projeto2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CarroCRUD {

	protected SessionFactory sessionFactory;
	 
    protected void setup() {
    	
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	      //  .configure() // configures settings from hibernate.cfg.xml
    	      //  .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    		//sessionFactory = configuration.buildSessionFactory();
    	} catch (Exception ex) {
    	   StandardServiceRegistryBuilder.destroy(registry);
    		
    	}
    }
    
    protected void exit() {
        // code to close Hibernate Session factory
    }

    
    protected void create(Carro carro) {
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
     
        session.save(carro);
        
        session.getTransaction().commit();
        session.close();
    }
    
 
    protected Carro read(int id) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Carro carro = session.get(Carro.class, id);
     
        session.close();
        return carro;
    }
 
    protected void update(Carro carro) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

    	session.update(carro);

    	session.getTransaction().commit();
    	session.close(); 	
    }
 
    protected void delete(int id) {
    	Carro carro = new Carro();
        carro.setId(id);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(carro);
     
        session.getTransaction().commit();
        session.close();
    }
    

    
    public List<Carro> listAll() {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();

        // leitura via Hibernate Query Language (HQL).
        List<Carro> carros = session.createQuery("from Carro", Carro.class).getResultList();
        session.getTransaction().commit();

        return carros;
    }
    
    public Carro queryWhere(int id) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Carro carro = session.createQuery("from Carro where id="+id, Carro.class).getSingleResult();
        
        session.close();
        return carro;
    }
	
}
