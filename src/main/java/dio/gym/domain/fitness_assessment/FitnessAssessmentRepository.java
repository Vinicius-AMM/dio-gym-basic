package dio.gym.domain.fitness_assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessAssessmentRepository extends JpaRepository<FitnessAssessment, Long> {
}
