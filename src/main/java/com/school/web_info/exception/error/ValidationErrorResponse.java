package com.school.web_info.exception.error;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {}

