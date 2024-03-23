package com.school.web_info.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@RequiredArgsConstructor(staticName = "of")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Answer {
    @NonNull
    String question;
    @NonNull
    List<String> answers;
    @NonNull
    String rightAnswer;
}
