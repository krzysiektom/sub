package tomala.sub.location;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("locations")
public class LocationController {

    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/all")
    public String allLocation(Model model) {
        model.addAttribute("locations", locationRepository.findAll());
        return "locations/allLocations";
    }

    @GetMapping("/add")
    public String showForm() {
        return "locations/locationForm";
    }

    @PostMapping("/add")
    public String addLocation(@ModelAttribute("location") @Valid Location location, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "locations/locationForm";
        }
        locationRepository.save(location);
        return "redirect:/locations/all";
    }

    @GetMapping("/edit/{id}")
    public String showForm(@PathVariable Long id, Model model) {
        model.addAttribute("location", locationRepository.getOne(id));
        return "locations/locationForm";
    }

    @PostMapping("/edit/{id}")
    public String editLocation(@ModelAttribute("location") @Valid Location location, BindingResult result) {
        if (result.hasErrors()) {
            return "locations/locationForm";
        }
        locationRepository.save(location);
        return "redirect:/locations/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationRepository.delete(locationRepository.getOne(id));
        return "redirect:/locations/all";
    }

    @ResponseBody
    @GetMapping("/rest/")
    public List<Location> allRESTLocation() {
        return locationRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/rest/{id}")
    public Location RESTLocationById(@PathVariable Long id) {
        return locationRepository.getOne(id);
    }

}
