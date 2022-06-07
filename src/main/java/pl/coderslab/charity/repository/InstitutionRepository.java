package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution findByName(String name);
}
