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
package org.assertj.swing.driver;

import static org.assertj.swing.data.Index.atIndex;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Tests for {@link JTabbedPaneDriver#requireTabTitle(javax.swing.JTabbedPane, String, org.assertj.swing.data.Index)}.
 * 
 * @author Alex Ruiz
 */
public class JTabbedPaneDriver_requireTabTitleAsText_Test extends JTabbedPaneDriver_TestCase {
  @Test
  public void should_Fail_If_Title_Is_Not_Equal_To_Expected() {
    thrown.expectAssertionError("titleAt", "One", Pattern.compile("Hello"));
    driver.requireTabTitle(tabbedPane, "Hello", atIndex(0));
  }

  @Test
  public void should_Pass_If_Title_Is_Equal_To_Expected() {
    driver.requireTabTitle(tabbedPane, "One", atIndex(0));
  }

  @Test
  public void should_Pass_If_Title_Matches_Pattern() {
    driver.requireTabTitle(tabbedPane, "O.*", atIndex(0));
  }
}