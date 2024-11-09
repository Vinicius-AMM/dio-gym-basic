package dio.gym.service.config;

import dio.gym.domain.fitness_assessment.FitnessAssessmentRepository;
import dio.gym.domain.member.MemberRepository;
import dio.gym.service.impl.FitnessAssessmentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FitnessAssessmentServiceConfig {
    @Bean
    public FitnessAssessmentServiceImpl fitnessAssessmentService(FitnessAssessmentRepository fitnessAssessmentRepository, MemberRepository memberRepository) {
        return new FitnessAssessmentServiceImpl(fitnessAssessmentRepository, memberRepository);
    }
}