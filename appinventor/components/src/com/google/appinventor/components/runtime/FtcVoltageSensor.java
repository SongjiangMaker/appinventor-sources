// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2014 MIT, All rights reserved
// Released under the MIT License https://raw.github.com/mit-cml/app-inventor/master/mitlicense.txt

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

/**
 * A component for a voltage sensor of an FTC robot.
 *
 * @author lizlooney@google.com (Liz Looney)
 */
@DesignerComponent(version = YaVersion.FTC_VOLTAGE_SENSOR_COMPONENT_VERSION,
    description = "A component for a voltage sensor of an FTC robot.",
    category = ComponentCategory.FIRSTTECHCHALLENGE,
    nonVisible = true,
    iconName = "images/ftc.png")
@SimpleObject
@UsesLibraries(libraries = "RobotCore.jar")
public final class FtcVoltageSensor extends FtcHardwareDevice {

  private volatile VoltageSensor voltageSensor;

  /**
   * Creates a new FtcVoltageSensor component.
   */
  public FtcVoltageSensor(ComponentContainer container) {
    super(container.$form());
  }

  // Properties

  /**
   * Voltage property getter.
   */
  @SimpleProperty(description = "The Voltage.",
      category = PropertyCategory.BEHAVIOR)
  public double Voltage() {
    return (voltageSensor != null)
        ? voltageSensor.getVoltage()
        : 0;
  }

  // FtcRobotController.HardwareDevice implementation

  @Override
  public void debugHardwareDevice(StringBuilder sb) {
    sb.append("voltageSensor is ").append((voltageSensor == null) ? "null" : "not null").append("\n");
  }

  // FtcHardwareDevice implementation

  @Override
  void initHardwareDevice() {
    HardwareMap hardwareMap = getHardwareMap();
    if (hardwareMap != null) {
      voltageSensor = hardwareMap.voltageSensor.get(getDeviceName());
    }
  }

  @Override
  void clearHardwareDevice() {
    voltageSensor = null;
  }
}
