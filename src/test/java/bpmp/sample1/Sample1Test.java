package bpmp.sample1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.AbstractAssertions.init;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.repositoryService;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.runtimeService;

import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.assertj.core.api.Assertions;
public class Sample1Test {
    @Rule
    @ClassRule
   // public static ProcessEngineRule rule = new ProcessEngineRule();
    public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

    @Before
    public void setup() {
        init(rule.getProcessEngine());
    }

    @Test
    @Deployment(resources = "sample1.bpmn")
    public void testHappyPath() {
        ProcessDefinition pd = repositoryService().createProcessDefinitionQuery()
                .processDefinitionKey("sample1").
                        versionTag("1").
                        latestVersion().
                        singleResult();
        assertThat(pd).isNotNull();
        ProcessInstance processInstance = runtimeService().startProcessInstanceById(pd.getId());
        org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat(processInstance).isEnded();
    }
}
