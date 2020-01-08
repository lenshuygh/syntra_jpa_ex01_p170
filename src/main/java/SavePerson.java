import model.Address;
import model.Gender;
import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("person");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Person person = new Person();
            person.setBirthDay(LocalDate.of(1980,6,23));
            person.setFirstName("Lens");
            person.setLastName("Huygh");
            person.setGender(Gender.MALE);
            person.setMarried(false);

            Address address = new Address();
            address.setCity("Diepenbeek");
            address.setZipCode("3590");
            address.setCountry("Belgium");
            address.setStreet("Ganzestraat");
            address.setNumber("85");
            person.setAddress(address);

            entityManager.persist(person);
            entityTransaction.commit();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
            if(entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }
    }
}
