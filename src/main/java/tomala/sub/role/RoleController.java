package tomala.sub.role;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @ResponseBody
    @GetMapping("/rest")
    public List<Role> allRolesREST(){
        return roleRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/rest/{id}")
    public Role RoleByIdREST(@PathVariable Long id){
        return roleRepository.getOne(id);
    }

}
