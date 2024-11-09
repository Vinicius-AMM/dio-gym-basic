package dio.gym.domain.fitness_assessment;

import dio.gym.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_fitness_assessment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FitnessAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;
    private LocalDateTime assessmentDate = LocalDateTime.now();
    @Column(name = "current_weight")
    private Double weight;
    @Column(name = "current_height")
    private Double height;
}
