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

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Dimension;

import org.junit.Test;

/**
 * Tests for {@link WindowDriver#resizeHeightTo(java.awt.Window, int)} to ensure it works with {@link FrameDriver}.
 * 
 * @author Alex Ruiz
 */
public class FrameDriver_resizeHeightTo_Test extends FrameDriver_TestCase {
  @Test
  public void should_Resize_Frame() {
    showWindow();
    Dimension newSize = windowSize().addToHeight(40);
    driver.resizeHeightTo(window, newSize.height);
    assertThat(windowSize()).isEqualTo(newSize);
  }

  @Test
  public void should_Throw_Error_If_Frame_Is_Disabled() {
    disableWindow();
    thrown.expectIllegalStateIsDisabledComponent();
    driver.resizeHeightTo(window, 10);
  }

  @Test
  public void should_Throw_Error_If_Frame_Is_Not_Showing_On_The_Screen() {
    thrown.expectIllegalStateIsNotShowingComponent();
    driver.resizeHeightTo(window, 10);
  }

  @Test
  public void should_Throw_Error_If_Frame_Is_Not_Resizable() {
    makeWindowNotResizable();
    thrown.expectIllegalStateIsNotResizableComponent();
    driver.resizeHeightTo(window, 10);
  }
}