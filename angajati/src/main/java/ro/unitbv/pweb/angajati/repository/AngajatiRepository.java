package ro.unitbv.pweb.angajati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.unitbv.pweb.angajati.model.AngajatiModel;

@Repository
public interface AngajatiRepository extends JpaRepository<AngajatiModel, Long> {

}
