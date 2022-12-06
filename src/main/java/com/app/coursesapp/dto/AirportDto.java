package com.app.coursesapp.dto;

import java.util.Objects;

public class AirportDto {
    private String code;
    private String description;

    public AirportDto(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportDto that = (AirportDto) o;
        return Objects.equals(code, that.code) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
