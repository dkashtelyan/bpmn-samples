package bpmn.sample4;

import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Sample4Service1 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Map<String, Object> vars = delegateExecution.getVariables();
        String id = delegateExecution.getCurrentActivityId();
        System.out.println("In Service 1 from id: " + id + " Thread: " + Thread.currentThread().getId());
        Thread.sleep(1000);
        System.out.println("Out of Service 1 from id: " + id);
    }
}
