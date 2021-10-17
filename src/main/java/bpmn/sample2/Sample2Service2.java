package bpmn.sample2;

import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Sample2Service2 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Map<String, Object> vars = delegateExecution.getVariables();
        ComplexEntity complexEntity = (ComplexEntity) vars.get("complexEntity");
        Integer integer = (Integer) vars.get("int-val");
        System.out.println("Integer: " + integer);
        System.out.println("Complex Entity: " + complexEntity);
        vars.put("int-val", 2);
        complexEntity.setMessage("Good-bye");
        delegateExecution.setVariables(vars);
    }
}
