package dio.gym.service;

import dio.gym.domain.fitness_assessment.FitnessAssessment;
import dio.gym.domain.fitness_assessment.FitnessAssessmentForm;
import dio.gym.domain.fitness_assessment.FitnessAssessmentUpdateForm;

import java.util.List;

public interface IFitnessAssessmentService{
    FitnessAssessment create(FitnessAssessmentForm fitnessAssessmentToCreate);
    List<FitnessAssessment> findAll();
    FitnessAssessment findById(Long id);
    FitnessAssessment update(Long id, FitnessAssessmentUpdateForm fitnessAssessmentToUpdate);
    void deleteById(Long id);
}
