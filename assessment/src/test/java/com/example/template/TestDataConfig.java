package com.example.template;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import industrialaccident.domain.Assessment;
import industrialaccident.domain.AssessmentRepository;


@TestConfiguration
public class TestDataConfig {

    @Bean
    public CommandLineRunner initData(AssessmentRepository repository) {
        return args -> {
            Assessment assessment = new Assessment();
            assessment.setAccidentId(1L);
            assessment.setBusinessCode("bc_1");
            assessment.setEmployeeId("user01");
            assessment.setAssessorId(1L);
            assessment.setHospitalCode("hp_1");
            assessment.setDoctorNote("골절");
            repository.save(assessment);
        };
    }
}