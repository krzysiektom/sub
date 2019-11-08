package tomala.sub.sustitute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("substitute")
public class SubstituteController {

    @Autowired
    private SubstituteRepository substituteRepository;



    @ResponseBody
    @GetMapping("/rest/all")
    public List<Substitute> allRestSubstitute(){
        return substituteRepository.findAll();
    }
}
