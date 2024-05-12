package com.school.web_info.dto.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FilterUser(String name, @JsonProperty(value = "lastname") String lastName) {
}
