package com.school.web_info.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "tests")
@RequiredArgsConstructor(access = AccessLevel.PUBLIC,staticName = "of")
@NoArgsConstructor
public class Test {
    @Id
    private String _id;

    @NonNull
    private String name;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String imgUrl;

    @NonNull
    private List<Answer> answerList;
}
