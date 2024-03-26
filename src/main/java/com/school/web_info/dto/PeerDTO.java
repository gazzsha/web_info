package com.school.web_info.dto;


import com.school.web_info.validation.Birthday;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeerDTO {
    @NotBlank(message = "Не должно быть пустым")
    String nickname;
    @Birthday(message = "Возраст peer'a 18+")
    Date birthday;
}
