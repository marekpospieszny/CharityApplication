package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationServiceImplementation implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImplementation(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Donation get(Long id) {
        return donationRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public void update(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Integer countAllDonations() {
        return donationRepository.countAllDonations();
    }

    @Override
    public Integer sumAllDonationsBags() {
        return donationRepository.sumAllDonationsBags();
    }
}