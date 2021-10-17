package bpmn.sample8;

import java.util.Map;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ConsumeEventDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, Object> vars = execution.getVariables();
        if (vars != null) {
            for (String key : vars.keySet()) {
                System.out.println("Recieved data: " + key + ":" + vars.get(key) );
            }
            Object retries = vars.get("retries");
            if (retries != null && retries instanceof Integer) {
                Integer r = (Integer) retries;
                if (r > 0) {
                    execution.setVariable("retries", r - 1);
                    throw new BpmnError("Retrying");
                }
            }
        }
    }
}
