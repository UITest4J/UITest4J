/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.applet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for {@link BasicAppletStub#getParameter(String)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Price
 */
public class BasicAppletStub_getParameter_Test extends BasicAppletStub_TestCase {
  @Test
  public void should_Return_Parameter() {
    Map<String, String> parameters = new HashMap<>();
    parameters.put("key1", "value1");
    stub = new BasicAppletStub(viewer, context, parameters);
    assertThat(stub.getParameter("key1")).isEqualTo("value1");
  }
}
