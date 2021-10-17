package bpmn;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("bpmn-application")
public class BpmnApplication {

    public static void main(String... args) {
        SpringApplication.run(BpmnApplication.class, args);
    }
}
