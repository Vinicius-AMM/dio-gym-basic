package dio.gym.service;

import dio.gym.domain.registration.Registration;
import dio.gym.domain.registration.RegistrationForm;

import java.util.List;

public interface IRegistrationService {
    Registration create(RegistrationForm registrationToCreate);
    Registration findById(Long id);
    void deleteById(Long id);
}
