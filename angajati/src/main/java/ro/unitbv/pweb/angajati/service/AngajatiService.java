package ro.unitbv.pweb.angajati.service;

import java.util.List;

import ro.unitbv.pweb.angajati.model.AngajatiModel;

public interface AngajatiService {
		List<AngajatiModel> getAllAngajati(); 
		void saveAngajat(AngajatiModel angajat);
		AngajatiModel getaAngajatiModelbyId(long id);
		void deleteAngajatiModelById(long id);
}
