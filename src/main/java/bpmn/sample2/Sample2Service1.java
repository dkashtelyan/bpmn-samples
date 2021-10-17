package bpmn.sample2;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Sample2Service1 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Map<String, Object> vars = new HashMap<>();
        vars.put("int-val", 1);
        ComplexEntity complexEntity = new ComplexEntity();
        vars.put("complexEntity", complexEntity);
        vars.put("message-str", "hello from SampleService1");
        complexEntity.setId(1);
        complexEntity.setTime(LocalDateTime.now());
        complexEntity.setMessage("Hello");
        delegateExecution.setVariables(vars);
    }
}
