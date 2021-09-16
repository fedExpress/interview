package interview.wikicredit.exception;

import interview.wikicredit.domain.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<Object> handleAllExceptions(final BusinessException ex) {
        final ApiError apiError = new ApiError()
                .withErrCode(ex.getCode().name())
                .withDescription(ex.getCode().getDescription())
                .withStatus(HttpStatus.METHOD_NOT_ALLOWED);

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<Object> handleHttpExceptions(final HttpClientErrorException ex) {
        final ApiError apiError = new ApiError()
                .withDescription(ex.getLocalizedMessage())
                .withStatus(ex.getStatusCode());

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
