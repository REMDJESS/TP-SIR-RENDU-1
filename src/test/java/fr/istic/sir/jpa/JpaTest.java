package fr.istic.sir.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.sir.domain.ElectronicDevice;
import fr.istic.sir.domain.Heater;
import fr.istic.sir.domain.Home;
import fr.istic.sir.domain.Person;
import fr.istic.sir.domain.SmartDevice;

public class JpaTest {

	@SuppressWarnings("unused")
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		@SuppressWarnings("unused")
		JpaTest test = new JpaTest(em);

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Home h1 = new Home("27 avenue francois foulon");
		Home h2 = new Home("9 roue le sage ");
		Home h3 = new Home("478 istic bealieu ");
		Home h4 = new Home("2017 binome master 1 miage");
		Person p1 = new Person("anani","raymond", "M", "anani@gmail.com","ray");
		Person p2 = new Person("antonio","vasquez", " M "," antonio@gmail.com ","vasquez");
		Heater heat1 = new Heater("heatOne",5,25);
		Heater heat2 = new Heater("heatTwo",2,10);
		Heater heat3 = new Heater("heatThr",15,40);
		ElectronicDevice e1 = new ElectronicDevice("eDeviceOne","dishwasher");
		ElectronicDevice e2 = new ElectronicDevice("eDeviceTwo","microwave");
		
		List<Home> homes1 = new ArrayList<Home>();
		List<Home> homes2 = new ArrayList<Home>();
		List<Person> friends = new ArrayList<Person>();
		List<SmartDevice> devices1 = new ArrayList<SmartDevice>();
		List<SmartDevice> devices2 = new ArrayList<SmartDevice>();
		
		homes1.add(h1);
		homes1.add(h2);
		homes1.add(h3);
		homes2.add(h4);
		friends.add(p2);
		devices1.add(heat1);
		devices1.add(e2);
		devices2.add(e1);
		devices2.add(heat2);
		devices2.add(heat3);
		
		p1.setHomes(homes1);
		p2.setHomes(homes2);
		h1.setOwner(p1);
		h2.setOwner(p1);
		h3.setOwner(p1);
		h4.setOwner(p2);
		p1.setFriends(friends);
		h1.setDevices(devices1);
		h4.setDevices(devices2);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(heat1);
		em.persist(heat2);
		em.persist(heat3);
		em.persist(e1);
		em.persist(e2);
		
		tx.commit();

		List<Home> homesResult = em.createQuery("SELECT h FROM Home h", Home.class).getResultList();
		em.close();
		System.out.println("num of homes : "+homesResult.size());
		for(Home next : homesResult) {
			System.out.println("adress : " + next.getAdress());
		}
		System.out.println(".. done");
	}

}
