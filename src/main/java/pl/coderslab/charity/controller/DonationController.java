package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/form")
    public String addDonationForm(Model model) {
        model.addAttribute("institutions",institutionService.getAllInstitution());
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("donation",new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String acceptDonation(@Valid Donation donation, BindingResult result, Model model, HttpServletRequest  request) {
        if(result.hasErrors()) {
            model.addAttribute("institutions",institutionService.getAllInstitution());
            model.addAttribute("categories",categoryService.getAllCategories());
            return "form";
        }
//        Long institutionId = Long.parseLong(request.getParameter("organization"));
//        donation.setInstitution(institutionService.get(institutionId));
        String organizationName = request.getParameter("organization");
        donation.setInstitution(institutionService.getByName(organizationName));
        LocalTime time = LocalTime.parse(request.getParameter("time"));
        donation.setPickUpTime(time);
        donationService.add(donation);
        return "redirect:/";
    }


}
