package com.school.web_info.entity.test;

import com.school.web_info.entity.answer.Answer;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "test")
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
    @Column(name = "imgUrl")
    private String imgUrl;

    @NonNull
    @Column(name = "answerList")
    private List<Answer> answerList;

}
