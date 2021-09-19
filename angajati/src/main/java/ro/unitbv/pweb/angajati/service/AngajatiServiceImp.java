package ro.unitbv.pweb.angajati.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unitbv.pweb.angajati.model.AngajatiModel;
import ro.unitbv.pweb.angajati.repository.AngajatiRepository;

@Service
public class AngajatiServiceImp implements AngajatiService{

	@Autowired
	private AngajatiRepository angajatiRepository;
	
	@Override
	public List<AngajatiModel> getAllAngajati() {
		return angajatiRepository.findAll();
	}

	@Override
	public void saveAngajat(AngajatiModel angajat) {
		 this.angajatiRepository.save(angajat);
		
	}

	@Override
	public AngajatiModel getaAngajatiModelbyId(long id) {
		   Optional<AngajatiModel> optional = angajatiRepository.findById(id);
		   AngajatiModel angajatiModel = null; 
		   if(optional.isPresent()) {
			   angajatiModel = optional.get();
		   }
		   else {
			   throw new RuntimeException("Angajatul nu a fost gasit pt id :: " + id);
		   }
		return angajatiModel;
	}

	@Override
	public void deleteAngajatiModelById(long id) {
		this.angajatiRepository.deleteById(id);
		
	}

}
