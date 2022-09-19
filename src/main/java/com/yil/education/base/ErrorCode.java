/*
 * Copyright (c) 2022. Tüm hakları Yasin Yıldırım'a aittir.
 */

package com.yil.education.base;


import lombok.Getter;

@Getter
public enum ErrorCode {
    //Education ve EducationType enumları girilecek.
    EducationTypeNotFound(8000000, "Eğitim tip bilgisi bulunamadı!"),
    ;

    private final int code;

    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
