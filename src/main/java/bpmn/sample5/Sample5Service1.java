package bpmn.sample5;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Sample5Service1 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("In Service 1 from Thread: " + Thread.currentThread().getId());
        Thread.sleep(1000);
        System.out.println("Out of Service 1");
    }
}
