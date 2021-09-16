package interview.wikicredit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.http.HttpStatus;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String description;
    private String errCode;
}
