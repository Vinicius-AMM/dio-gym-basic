package dio.gym.domain.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberForm {
    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String neighborhood;

    @NotNull
    private LocalDate birthDate;

}
