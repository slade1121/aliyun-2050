/*
 * Classname:   BIotProxyBase
 *
 * Version:     1.0
 *
 * Date:        4/6/2022
 *
 * Copyright (c) 2022 PHOENIX CONTACT
 */

package com.phoenixcontact.AliyunIotMqtt.proxy;

import com.aliyun.alink.linksdk.tmp.device.payload.ValueWrapper;
import com.phoenixcontact.AliyunIotMqtt.BAliIotDriver;
import com.phoenixcontact.AliyunIotMqtt.Devices.ReportData;
import com.phoenixcontact.AliyunIotMqtt.support.AccessMode;
import com.phoenixcontact.AliyunIotMqtt.support.IotProperty;
import com.tridium.driver.util.DrUtil;

import javax.baja.control.*;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.logging.Logger;

/**
 * TODO Description
 *
 * @author songyantao@phoenixcontact.com.cn
 * @version 1.0
 * @since 4/6/2022
 */

//TODO      "accessMode": "rw",
@NiagaraProperty(name = "identifier", type = "String", defaultValue = "", flags = Flags.READONLY)
@NiagaraProperty(name = "required", type = "boolean", defaultValue = "false", flags = Flags.READONLY)
@NiagaraAction(name = "IotNotify")
@NiagaraProperty(name = "notifyWhenChanged", type = "boolean", defaultValue = "true")

@NiagaraType
public abstract class BIotProxyBase extends BComponent {


    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.phoenixcontact.AliyunIotMqtt.proxy.BIotProxyBase(3499357037)1.0$ @*/
/* Generated Wed Apr 06 19:58:59 CST 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "identifier"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code identifier} property.
   * @see #getIdentifier
   * @see #setIdentifier
   */
  public static final Property identifier = newProperty(Flags.READONLY, "", null);
  
  /**
   * Get the {@code identifier} property.
   * @see #identifier
   */
  public String getIdentifier() { return getString(identifier); }
  
  /**
   * Set the {@code identifier} property.
   * @see #identifier
   */
  public void setIdentifier(String v) { setString(identifier, v, null); }

////////////////////////////////////////////////////////////////
// Property "required"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code required} property.
   * @see #getRequired
   * @see #setRequired
   */
  public static final Property required = newProperty(Flags.READONLY, false, null);
  
  /**
   * Get the {@code required} property.
   * @see #required
   */
  public boolean getRequired() { return getBoolean(required); }
  
  /**
   * Set the {@code required} property.
   * @see #required
   */
  public void setRequired(boolean v) { setBoolean(required, v, null); }

////////////////////////////////////////////////////////////////
// Property "notifyWhenChanged"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code notifyWhenChanged} property.
   * @see #getNotifyWhenChanged
   * @see #setNotifyWhenChanged
   */
  public static final Property notifyWhenChanged = newProperty(0, true, null);
  
  /**
   * Get the {@code notifyWhenChanged} property.
   * @see #notifyWhenChanged
   */
  public boolean getNotifyWhenChanged() { return getBoolean(notifyWhenChanged); }
  
  /**
   * Set the {@code notifyWhenChanged} property.
   * @see #notifyWhenChanged
   */
  public void setNotifyWhenChanged(boolean v) { setBoolean(notifyWhenChanged, v, null); }

////////////////////////////////////////////////////////////////
// Action "IotNotify"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code IotNotify} action.
   * @see #IotNotify()
   */
  public static final Action IotNotify = newAction(0, null);
  
  /**
   * Invoke the {@code IotNotify} action.
   * @see #IotNotify
   */
  public void IotNotify() { invoke(IotNotify, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BIotProxyBase.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void applyParameters(IotProperty config) {
        setIdentifier(config.getIdentifier());
        setRequired(config.isRequired());
    }

    @Override
    public void started() throws Exception {
        super.started();
    }

    @Override
    public void changed(Property property, Context context) {
        if (!this.isRunning()) {
            return;
        }
        super.changed(property, context);

    }


    private Logger log = Logger.getLogger(getClass().getSimpleName());

    public abstract Object getValue();

    public abstract void UpdataReportData() ;

    public BIotProxyBase() {
    }

    public void doIotNotify() {
        ((BAliIotDriver) DrUtil.getParent(this, BAliIotDriver.TYPE)).onPointNotify(this);
    }

    public static BControlPoint CREATE(IotProperty config) {
        if (config.getDataType().equals("int")||config.getDataType().equals("double")) {
            BNumericWritable point = new BNumericWritable();
            BIotNumericWriteableProxy proxy = new BIotNumericWriteableProxy();
            proxy.applyParameters(config);
            point.add("iotProxy", proxy);
            return point;
        }
        if (config.getDataType().equals("bool")) {
            BBooleanWritable point = new BBooleanWritable();
            BIotBooleanWriteableProxy proxy = new BIotBooleanWriteableProxy();
            proxy.applyParameters(config);
            point.add("iotProxy", proxy);
            return point;
        }
        return null;
    }

}