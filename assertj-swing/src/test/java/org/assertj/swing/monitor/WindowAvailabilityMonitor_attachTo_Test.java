/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.swing.monitor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.swing.listener.WeakEventListener;
import org.junit.Test;

/**
 * Tests for {@link WindowAvailabilityMonitor#attachTo(java.awt.Toolkit)}.
 * 
 * @author Alex Ruiz
 */
public class WindowAvailabilityMonitor_attachTo_Test extends WindowAvailabilityMonitor_TestCase {
  @Test
  public void should_Attach_Itself_To_Toolkit() {
    monitor.attachTo(toolkit);
    List<WeakEventListener> eventListeners = toolkit.eventListenersUnderEventMask(EVENT_MASK, WeakEventListener.class);
    assertThat(eventListeners).hasSize(1);
    WeakEventListener weakEventListener = eventListeners.get(0);
    assertThat(weakEventListener.underlyingListener()).isSameAs(monitor);
  }
}
