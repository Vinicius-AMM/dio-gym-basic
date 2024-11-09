package dio.gym.controller;

import dio.gym.domain.fitness_assessment.FitnessAssessment;
import dio.gym.domain.fitness_assessment.FitnessAssessmentForm;
import dio.gym.domain.fitness_assessment.FitnessAssessmentUpdateForm;
import dio.gym.service.impl.FitnessAssessmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitnessAssessments")
public class FitnessAssessmentController {
    @Autowired
    private FitnessAssessmentServiceImpl fitnessAssessmentService;

    @PostMapping
    public FitnessAssessment create(@Valid @RequestBody FitnessAssessmentForm fitnessAssessmentToCreate){
        return fitnessAssessmentService.create(fitnessAssessmentToCreate);
    }

    @GetMapping("/{id}")
    public FitnessAssessment findById(@PathVariable Long id){
        return fitnessAssessmentService.findById(id);
    }

    @PutMapping("/{id}")
    public FitnessAssessment update(@PathVariable Long id, @Valid @RequestBody FitnessAssessmentUpdateForm fitnessAssessmentToUpdate){
        return fitnessAssessmentService.update(id, fitnessAssessmentToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        fitnessAssessmentService.deleteById(id);
    }



}
