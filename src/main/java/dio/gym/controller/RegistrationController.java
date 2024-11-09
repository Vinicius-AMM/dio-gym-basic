package dio.gym.controller;

import dio.gym.domain.registration.Registration;
import dio.gym.domain.registration.RegistrationForm;
import dio.gym.service.impl.RegistrationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationServiceImpl registrationService;

    @PostMapping
    public Registration create(@Valid @RequestParam RegistrationForm registrationToCreate){
        return registrationService.create(registrationToCreate);
    }

    @GetMapping("{id}")
    public Registration findById(@PathVariable Long id){
        return registrationService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        registrationService.deleteById(id);
    }
}
