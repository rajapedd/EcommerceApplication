package com.raja.product.ProductService.error;

import com.raja.product.ProductService.model.ErrorResponce;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductResponseEntityErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponce> handleException(ProductServiceCustomException exception){
        return new ResponseEntity<>(new ErrorResponce().builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build() , HttpStatus.NOT_FOUND);
    }
}
