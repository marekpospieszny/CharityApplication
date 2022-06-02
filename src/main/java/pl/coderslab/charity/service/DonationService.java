package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {

    List<Donation> getAllDonations();

    void add(Donation donation);

    Donation get(Long id);

    void delete(Long id);

    void update(Donation donation);

    Integer countAllDonations();

    Integer sumAllDonationsBags();
}