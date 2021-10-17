package bpmn.sample6;

import java.util.Map;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NotifyDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Map<String, Object> vars = delegateExecution.getVariables();
        Integer retries = (Integer) vars.get("retries");
        if (retries == null) {
            System.out.println("retries is not set");
            return;
        }
        if (retries > 0) {
            delegateExecution.setVariable("retries", retries - 1);
            System.out.println("Will retry for " + retries + " times");
            throw new BpmnError("Retrying...");
        }
    }
}
