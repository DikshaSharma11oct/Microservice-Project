package com.Question.QuestionMicroservice.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseList {

    private Long questionId;
    private String questionName;
    private String questionTitle;

}
