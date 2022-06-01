package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> getAllInstitution();

    void add(Institution institution);

    Institution get(Long id);

    void delete(Long id);

    void update(Institution institution);
}
