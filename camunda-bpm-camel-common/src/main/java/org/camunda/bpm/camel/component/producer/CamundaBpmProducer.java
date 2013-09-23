/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.camel.component.producer;

import static org.camunda.bpm.camel.component.CamundaBpmConstants.CAMUNDA_BPM_BUSINESS_KEY;
import static org.camunda.bpm.camel.component.CamundaBpmConstants.CAMUNDA_BPM_PROCESS_INSTANCE_ID;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.camunda.bpm.camel.component.CamundaBpmEndpoint;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceQuery;

public abstract class CamundaBpmProducer extends DefaultProducer {

  protected ProcessEngine processEngine;
  protected RuntimeService runtimeService;
  protected Map<String, Object> parameters;

  public CamundaBpmProducer(CamundaBpmEndpoint endpoint, Map<String, Object> parameters) {
    super(endpoint);
    this.processEngine = endpoint.getProcessEngine();
    this.runtimeService = processEngine.getRuntimeService();
    this.parameters = parameters;
  }
  

  
  protected CamundaBpmEndpoint getCamundaBpmEndpoint() {
    return (CamundaBpmEndpoint) getEndpoint();
  }  
}
