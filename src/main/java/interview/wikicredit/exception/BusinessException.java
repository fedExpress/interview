package interview.wikicredit.exception;

import interview.wikicredit.domain.EErrorCode;
import lombok.*;

@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends Exception {
    private EErrorCode code;
}
