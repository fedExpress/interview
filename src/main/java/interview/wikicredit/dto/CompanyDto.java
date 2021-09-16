package interview.wikicredit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.NotNull;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    Long id;
    @NotNull
    String title;
}
