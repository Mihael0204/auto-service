package com.example.autoservice.model;

public enum Status {
    IN_PROCESS("In process"),
    ACCEPTED("Accepted"),
    COMPLETED("Completed"),
    FAILURE("Failure"),
    PAID("Paid");

    private final String value;

    Status(String value) {
        this.value = value;
    }
}
