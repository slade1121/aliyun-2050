/*
 * Classname:   BAliIotDriver
 *
 * Version:     1.0
 *
 * Date:        4/6/2022
 *
 * Copyright (c) 2022 PHOENIX CONTACT
 */

package com.phoenixcontact.AliyunIotMqtt;

import com.phoenixcontact.AliyunIotMqtt.proxy.BIotProxyBase;
import com.phoenixcontact.AliyunIotMqtt.support.IotProperty;
import com.tridium.json.JSONArray;
import com.tridium.json.JSONObject;

import javax.baja.control.BControlPoint;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * TODO Description
 *
 * @author songyantao@phoenixcontact.com.cn
 * @version 1.0
 * @since 4/6/2022
 */

@NiagaraType
@NiagaraAction(name = "CreateModel", parameterType = "BString", defaultValue = "BString.DEFAULT", facets = {@Facet(name = "BFacets.MULTI_LINE", value = "BBoolean.TRUE")})

@NiagaraAction(name = "testSend")

public class BAliIotDriver extends BComponent {


    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.phoenixcontact.AliyunIotMqtt.BAliIotDriver(2740775840)1.0$ @*/
    /* Generated Wed Apr 06 17:33:52 CST 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Action "CreateModel"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code CreateModel} action.
     *
     * @see #CreateModel(BString parameter)
     */
    public static final Action CreateModel = newAction(0, BString.DEFAULT, BFacets.make(BFacets.MULTI_LINE, BBoolean.TRUE));

    /**
     * Invoke the {@code CreateModel} action.
     *
     * @see #CreateModel
     */
    public void CreateModel(BString parameter) {
        invoke(CreateModel, parameter, null);
    }

////////////////////////////////////////////////////////////////
// Action "testSend"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code testSend} action.
     *
     * @see #testSend()
     */
    public static final Action testSend = newAction(0, null);

    /**
     * Invoke the {@code testSend} action.
     *
     * @see #testSend
     */
    public void testSend() {
        invoke(testSend, null, null);
    }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BAliIotDriver.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    ConcurrentHashMap<String, BIotProxyBase> ProxyMap = new ConcurrentHashMap<>();

    public void doCreateModel(BString msg) {
        this.removeAll();
        List<IotProperty> props = new ArrayList<>();
        JSONObject obj = new JSONObject(msg.toString());
        JSONArray arr = obj.getJSONArray("properties");
        for (int i = 0; i < arr.length(); i++) {
            props.add(IotProperty.CREATE(arr.getJSONObject(i)));
        }

        for (IotProperty prop : props) {
            BControlPoint p = BIotProxyBase.CREATE(prop);
            if (p != null) {
                this.add(prop.getName(), p);
            }
        }
        buildPointsRef();
    }

    public void doTestSend() {
        ProxyMap.values().forEach(p -> {
            System.out.println(p.getValue());
        });
    }

    private void buildPointsRef() {
        ProxyMap.clear();
        BControlPoint[] cps = this.getChildren(BControlPoint.class);
        for (BControlPoint cp : cps) {
            BIotProxyBase[] ps = cp.getChildren(BIotProxyBase.class);
            if (ps.length != 0) {
                BIotProxyBase p = ps[0];
                ProxyMap.put(p.getIdentifier(), p);
            }
        }
    }

    public void onPointNotify(BIotProxyBase point) {
        System.out.println(point.getValue());
    }

    @Override
    public void started() throws Exception {
        super.started();
        buildPointsRef();
    }

    @Override
    public void changed(Property property, Context context) {
        if (!this.isRunning()) {
            return;
        }
        super.changed(property, context);

    }


    private Logger log = Logger.getLogger(getClass().getSimpleName());

    public BAliIotDriver() {
    }
}