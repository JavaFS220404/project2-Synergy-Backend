package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.repositories.AvengerDAO;

@Service
public class AvengerService {

	private AvengerDAO avengerDao;
	private HomeService homeService;
	
	@Autowired
	public AvengerService(AvengerDAO avengerDao) {
		super();
		this.avengerDao = avengerDao;
		this.homeService = homeService;
	}
	
	public List<Avenger> getAllAvengers(){
		return avengerDao.findAll();
	}
	
	public Avenger findById(int id) {
		Optional<Avenger> opt = avengerDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public void addOrUpdateAvenger(Avenger avenger) {
		if(avenger.getHome()!=null &&  avenger.getHome().getId()==0){
			Home home = homeService.addOrUpdateHome(avenger.getHome());
			avenger.setHome(home);
		}
		avengerDao.save(avenger); //save will saveOrUpdate in Spring Data Jpa
	}
	
	public void destroyAvenger(int id) {
		Avenger avenger = findById(id);
		avengerDao.delete(avenger);
	}
	
	public List<Avenger> getBySuperheroName(String name){
		Optional<List<Avenger>> opt = avengerDao.findBySuperheroName(name);
		if(opt.isPresent()) {
			return opt.get();
		}
		return new ArrayList<Avenger>(); //empty list 
	}
}
