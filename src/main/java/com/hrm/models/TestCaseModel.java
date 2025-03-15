package com.hrm.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestCaseModel {
    private String testcaseName;
    private String priority;
    private String steps;

    public String getTestcaseName() {
        return testcaseName;
    }

    public void setTestcaseName(String testcaseName) {
        this.testcaseName = testcaseName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
