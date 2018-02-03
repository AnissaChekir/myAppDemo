package org.sid;




import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Chekir","Anissa",df.parse("12/12/2012"),"anissa.ch.ma@gmail.com",95990784,"anissa.png"));
		contactRepository.save(new Contact("Chekir1","Anissa1",df.parse("12/12/2000"),"anissa.ch.ma@gmail.com",93156785,"anissa1.png"));
		contactRepository.save(new Contact("Chekir2","Anissa2",df.parse("12/10/1994"),"anissa2.ch.ma@gmail.com",95990784,"anissa2.png"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}
}
