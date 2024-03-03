package com.school.web_info.dto;


import com.school.web_info.validation.Birthday;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeerDTO {
    @NotBlank
    String nickname;

    @Birthday
    Date birthday;
}
