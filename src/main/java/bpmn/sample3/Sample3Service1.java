package bpmn.sample3;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Sample3Service1 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("In Service 1 Thread: " + Thread.currentThread().getId());
        Thread.sleep(1000);
        System.out.println("Out of Service 1");
    }
}
