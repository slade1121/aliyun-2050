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
import com.phoenixcontact.AliyunIotMqtt.Devices.BAliyunDevices;
import com.phoenixcontact.AliyunIotMqtt.Devices.ReportData;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusString;
import javax.baja.sys.*;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * TODO Description
 *
 * @author songyantao@phoenixcontact.com.cn
 * @version 1.0
 * @since 4/6/2022
 */

@NiagaraType
@NiagaraProperty(name = "shadow", type = "BStatusString", defaultValue = "new BStatusString()", flags = Flags.HIDDEN)
public class BIotDateWriteableProxy extends BIotProxyBase {



    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.phoenixcontact.AliyunIotMqtt.proxy.BIotDateWriteableProxy(3800429807)1.0$ @*/
/* Generated Mon Apr 18 11:52:18 CST 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "shadow"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code shadow} property.
   * @see #getShadow
   * @see #setShadow
   */
  public static final Property shadow = newProperty(Flags.HIDDEN, new BStatusString(), null);

    /**
   * Get the {@code shadow} property.
   * @see #shadow
   */
  public BStatusString getShadow() { return (BStatusString)get(shadow); }
  
  /**
   * Set the {@code shadow} property.
   * @see #shadow
   */
  public void setShadow(BStatusString v) { set(shadow, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BIotDateWriteableProxy.class);

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
//            UpdataReportData();
        }
    }

    @Override
    public Object getValue() {
        return ((BStatusString) this.getParent().get("out")).getValue();

    }

    @Override
    public ValueWrapper<?> getValueWrapper() {
//        return new ValueWrapper.DateValueWrapper((String) getValue());
        Calendar cal = Calendar.getInstance();
        long currenTimeUTC = cal.getTimeInMillis();
        String timeUTC = String.valueOf(currenTimeUTC);
        return new ValueWrapper.DateValueWrapper((String) timeUTC);
    }



//    @Override
//    public void UpdataReportData() {
//
//        ReportData.getInstance().ReportDataWrapperMap.computeIfAbsent(getIdentifier(),i->new ValueWrapper.DateValueWrapper((String) getValue())).setValue((String)getValue());
//
//    }



    private Logger log = Logger.getLogger(getClass().getSimpleName());

    public BIotDateWriteableProxy() {
    }
}