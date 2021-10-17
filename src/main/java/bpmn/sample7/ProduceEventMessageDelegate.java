package bpmn.sample7;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ProduceEventMessageDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Producing eventSample");
        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("eventSample")
                .setVariable("someVariable", "someValue")
                .setVariable("retries", 3)
                .correlateWithResult();
    }
}
