package interview.wikicredit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class WikipediaDataDto {
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private Long pageid;

    @NotNull
    private String extract;

    @NotNull
    private Timestamp timestamp;

    @JsonIgnore
    private CompanyDto companyDto;
}
