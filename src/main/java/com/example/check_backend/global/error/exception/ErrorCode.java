package com.example.check_backend.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    // subject
    SUBJECT_NOT_FOUND(404, "Subject not found."),

    // jwt
    EXPIRED_TOKEN(401, "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    // checkListContent
    CHECKLIST_CONTENT_NOT_FOUND(404, "Check list content not found."),

    // checklist
    CHECKLIST_NOT_FOUND(404, "Checklist not found."),

    // user
    USER_NOT_FOUND(404, "User not found"),
    USER_ALREADY_EXISTS(409, "User already exists"),
    PASSWORD_MISMATCH(404, "Password mismatch"),

    // general
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;
}
