package Pegas.http.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice(basePackages = "Pegas.http.rest")
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception exception){
        log.error("Failed to return response", exception);
            return "error/error500";
    }

}
