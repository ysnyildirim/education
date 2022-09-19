package com.yil.education.exception;

import com.yil.education.base.ApiException;
import com.yil.education.base.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ApiException(code = ErrorCode.EducationTypeNotFound)
public class EducationTypeNotFoundException extends Exception {
}
