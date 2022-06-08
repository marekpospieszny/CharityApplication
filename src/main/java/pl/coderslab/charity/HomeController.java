package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionService.getAllInstitution());
        model.addAttribute("donationsCount", donationService.countAllDonations());
        model.addAttribute("donationsBags", donationService.sumAllDonationsBags());
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }
}