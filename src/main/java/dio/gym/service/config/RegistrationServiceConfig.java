package dio.gym.service.config;

import dio.gym.domain.member.MemberRepository;
import dio.gym.domain.registration.RegistrationRepository;
import dio.gym.service.impl.RegistrationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrationServiceConfig {
    @Bean
    public RegistrationServiceImpl registrationService(RegistrationRepository registrationRepository, MemberRepository memberRepository) {
        return new RegistrationServiceImpl(registrationRepository, memberRepository);
    }
}