package org.sid.web;

import java.util.List;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class ContactRestService {
	
	@Autowired
	private ContactRepository contactRepository;
	//afichage de la liste des contact
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContact(){
		return contactRepository.findAll();
	}
	
	//Afichage d'un contact
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id) {
		return contactRepository.findOne(id);
	}
	
	//Ajouter un contact
	@RequestMapping(value="/contacts", method= RequestMethod.POST)
	public Contact save(@RequestBody Contact c) {
		return contactRepository.save(c);
	}
	
	//SUPRIMER contact
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		contactRepository.delete(id);
		return true;
		
	}
	
	//Mise a jour 
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact save(@PathVariable Long id, @RequestBody Contact c) {
		c.setId(id);
		return contactRepository.save(c);
	}

}
