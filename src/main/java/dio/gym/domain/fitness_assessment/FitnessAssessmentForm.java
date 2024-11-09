package dio.gym.domain.fitness_assessment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FitnessAssessmentForm {
    private Long memberId;
    private Double weight;
    private Double height;
}
