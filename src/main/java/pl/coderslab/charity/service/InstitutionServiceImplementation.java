package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionServiceImplementation implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImplementation(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> getAllInstitution() {
        return institutionRepository.findAll();
    }

    @Override
    public void add(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public Institution get(Long id) {
        return institutionRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public void update(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public Institution getByName(String name) {
        return institutionRepository.findByName(name);
    }
}
