/*
 * Classname:   BIotNumericWriteableProxy
 *
 * Version:     1.0
 *
 * Date:        4/6/2022
 *
 * Copyright (c) 2022 PHOENIX CONTACT
 */

package com.phoenixcontact.AliyunIotMqtt.proxy;

import com.aliyun.alink.linksdk.tmp.device.payload.ValueWrapper;
import com.phoenixcontact.AliyunIotMqtt.Devices.ReportData;
import com.phoenixcontact.AliyunIotMqtt.support.IotProperty;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusNumeric;
import javax.baja.sys.*;
import java.util.logging.Logger;

/**
 * TODO Description
 *
 * @author songyantao@phoenixcontact.com.cn
 * @version 1.0
 * @since 4/6/2022
 */

@NiagaraType
@NiagaraProperty(name = "shadow", type = "BStatusNumeric", defaultValue = "new BStatusNumeric()", flags = Flags.HIDDEN)
@NiagaraProperty(name = "AsInt", type = "boolean", defaultValue = "false",flags = Flags.READONLY)
public class BIotNumericWriteableProxy extends BIotProxyBase {


    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.phoenixcontact.AliyunIotMqtt.proxy.BIotNumericWriteableProxy(1406265527)1.0$ @*/
/* Generated Mon Apr 18 14:38:02 CST 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "shadow"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code shadow} property.
   * @see #getShadow
   * @see #setShadow
   */
  public static final Property shadow = newProperty(Flags.HIDDEN, new BStatusNumeric(), null);
  
  /**
   * Get the {@code shadow} property.
   * @see #shadow
   */
  public BStatusNumeric getShadow() { return (BStatusNumeric)get(shadow); }
  
  /**
   * Set the {@code shadow} property.
   * @see #shadow
   */
  public void setShadow(BStatusNumeric v) { set(shadow, v, null); }

////////////////////////////////////////////////////////////////
// Property "AsInt"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AsInt} property.
   * @see #getAsInt
   * @see #setAsInt
   */
  public static final Property AsInt = newProperty(Flags.READONLY, false, null);
  
  /**
   * Get the {@code AsInt} property.
   * @see #AsInt
   */
  public boolean getAsInt() { return getBoolean(AsInt); }
  
  /**
   * Set the {@code AsInt} property.
   * @see #AsInt
   */
  public void setAsInt(boolean v) { setBoolean(AsInt, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BIotNumericWriteableProxy.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Override
    public void started() throws Exception {
        super.started();
        this.linkTo((BComponent) this.getParent(), this.getParent().getSlot("out"), shadow);
    }

    @Override
    public void changed(Property property, Context context) {
        if (!this.isRunning()) {
            return;
        }
        super.changed(property, context);
        if (property == shadow && this.getNotifyWhenChanged()) {
            doIotNotify();
        }
    }


    @Override
    public Object getValue() {
        return ((BStatusNumeric) this.getParent().get("out")).getValue();
    }

    @Override
    public ValueWrapper<?> getValueWrapper() {
        if(this.getAsInt()){
            return new ValueWrapper.IntValueWrapper(((Double) getValue()).intValue());
        }else{
            return new ValueWrapper.DoubleValueWrapper(((Double) getValue()));
        }
    }

    private Logger log = Logger.getLogger(getClass().getSimpleName());

    public BIotNumericWriteableProxy() {
    }
}