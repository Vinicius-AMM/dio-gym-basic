package dio.gym.domain.member;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberUpdateForm {
    private String name;
    private String neighborhood;
    private LocalDate birthDate;
}
