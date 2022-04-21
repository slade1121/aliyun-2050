/*
 * Classname:   BAliyunDevices
 *
 * Version:     1.0
 *
 * Date:        2022/3/25
 *
 * Copyright (c) 2022 PHOENIX CONTACT
 */

package com.phoenixcontact.AliyunIotMqtt.Devices;

import com.aliyun.alink.apiclient.CommonRequest;
import com.aliyun.alink.apiclient.CommonResponse;
import com.aliyun.alink.apiclient.IoTCallback;
import com.aliyun.alink.apiclient.threadpool.ThreadPool;
import com.aliyun.alink.apiclient.utils.StringUtils;
import com.aliyun.alink.dm.api.DeviceInfo;
import com.aliyun.alink.dm.api.InitResult;
import com.aliyun.alink.dm.api.IoTApiClientConfig;
import com.aliyun.alink.dm.model.ResponseModel;
import com.aliyun.alink.linkkit.api.ILinkKitConnectListener;
import com.aliyun.alink.linkkit.api.IoTMqttClientConfig;
import com.aliyun.alink.linkkit.api.LinkKit;
import com.aliyun.alink.linkkit.api.LinkKitInitParams;
import com.aliyun.alink.linksdk.channel.core.base.AError;
import com.aliyun.alink.linksdk.tmp.device.payload.ValueWrapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.alibaba.fastjson.JSONObject;


import com.phoenixcontact.AliyunIotMqtt.proxy.BIotDateWriteableProxy;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusBoolean;
import javax.baja.sys.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * TODO Description
 *
 * @author
 * @version 1.0
 * @since 2022/3/25
 */

@NiagaraType

@NiagaraProperty(name = "productKey", type = "BString", defaultValue = "gthyoZkqWkM", flags = Flags.SUMMARY)
@NiagaraProperty(name = "productSecret", type = "BString", defaultValue = "HGqn7YFQYpSolh5D", flags = Flags.SUMMARY)
@NiagaraProperty(name = "deviceName", type = "BString", defaultValue = "Device2", flags = Flags.SUMMARY)
@NiagaraProperty(name = "deviceSecret", type = "BString", defaultValue = "cf35f966cd037305b744af3550986fcb", flags = Flags.SUMMARY)
@NiagaraProperty(name = "regionId", type = "BString", defaultValue = "cn-shanghai", flags = Flags.SUMMARY)
@NiagaraProperty(name = "port", type = "int", defaultValue = "1883", flags = Flags.SUMMARY)
@NiagaraProperty(name = "ConnectStatus", type = "BStatusBoolean", defaultValue = "new BStatusBoolean(false)", flags = Flags.READONLY)
@NiagaraAction(name = "reconnect", flags = Flags.SUMMARY)
//@NiagaraAction(name = "disConnect", flags = Flags.SUMMARY)
//@NiagaraAction(name = "checkConnect", flags = Flags.HIDDEN)

//javax.baja.sys.TypeException: java.lang.NoClassDefFoundError: org/eclipse/paho/client/mqttv3/MqttException AliyunIotMqtt:AliyunDevices=com.phoenixcontact.AliyunIotMqtt.Devices.BAliyunDevices
public class BAliyunDevices extends BComponent {
    //region Slotomatic

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.phoenixcontact.AliyunIotMqtt.Devices.BAliyunDevices(3402996848)1.0$ @*/
/* Generated Thu Apr 14 16:56:24 CST 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "productKey"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code productKey} property.
   * @see #getProductKey
   * @see #setProductKey
   */
  public static final Property productKey = newProperty(Flags.SUMMARY, "gthyoZkqWkM", null);
  
  /**
   * Get the {@code productKey} property.
   * @see #productKey
   */
  public String getProductKey() { return getString(productKey); }
  
  /**
   * Set the {@code productKey} property.
   * @see #productKey
   */
  public void setProductKey(String v) { setString(productKey, v, null); }

////////////////////////////////////////////////////////////////
// Property "productSecret"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code productSecret} property.
   * @see #getProductSecret
   * @see #setProductSecret
   */
  public static final Property productSecret = newProperty(Flags.SUMMARY, "HGqn7YFQYpSolh5D", null);
  
  /**
   * Get the {@code productSecret} property.
   * @see #productSecret
   */
  public String getProductSecret() { return getString(productSecret); }
  
  /**
   * Set the {@code productSecret} property.
   * @see #productSecret
   */
  public void setProductSecret(String v) { setString(productSecret, v, null); }

////////////////////////////////////////////////////////////////
// Property "deviceName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code deviceName} property.
   * @see #getDeviceName
   * @see #setDeviceName
   */
  public static final Property deviceName = newProperty(Flags.SUMMARY, "Device2", null);
  
  /**
   * Get the {@code deviceName} property.
   * @see #deviceName
   */
  public String getDeviceName() { return getString(deviceName); }
  
  /**
   * Set the {@code deviceName} property.
   * @see #deviceName
   */
  public void setDeviceName(String v) { setString(deviceName, v, null); }

////////////////////////////////////////////////////////////////
// Property "deviceSecret"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code deviceSecret} property.
   * @see #getDeviceSecret
   * @see #setDeviceSecret
   */
  public static final Property deviceSecret = newProperty(Flags.SUMMARY, "cf35f966cd037305b744af3550986fcb", null);
  
  /**
   * Get the {@code deviceSecret} property.
   * @see #deviceSecret
   */
  public String getDeviceSecret() { return getString(deviceSecret); }
  
  /**
   * Set the {@code deviceSecret} property.
   * @see #deviceSecret
   */
  public void setDeviceSecret(String v) { setString(deviceSecret, v, null); }

////////////////////////////////////////////////////////////////
// Property "regionId"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code regionId} property.
   * @see #getRegionId
   * @see #setRegionId
   */
  public static final Property regionId = newProperty(Flags.SUMMARY, "cn-shanghai", null);
  
  /**
   * Get the {@code regionId} property.
   * @see #regionId
   */
  public String getRegionId() { return getString(regionId); }
  
  /**
   * Set the {@code regionId} property.
   * @see #regionId
   */
  public void setRegionId(String v) { setString(regionId, v, null); }

////////////////////////////////////////////////////////////////
// Property "port"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code port} property.
   * @see #getPort
   * @see #setPort
   */
  public static final Property port = newProperty(Flags.SUMMARY, 1883, null);
  
  /**
   * Get the {@code port} property.
   * @see #port
   */
  public int getPort() { return getInt(port); }
  
  /**
   * Set the {@code port} property.
   * @see #port
   */
  public void setPort(int v) { setInt(port, v, null); }

////////////////////////////////////////////////////////////////
// Property "ConnectStatus"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code ConnectStatus} property.
   * @see #getConnectStatus
   * @see #setConnectStatus
   */
  public static final Property ConnectStatus = newProperty(Flags.READONLY, new BStatusBoolean(false), null);
  
  /**
   * Get the {@code ConnectStatus} property.
   * @see #ConnectStatus
   */
  public BStatusBoolean getConnectStatus() { return (BStatusBoolean)get(ConnectStatus); }
  
  /**
   * Set the {@code ConnectStatus} property.
   * @see #ConnectStatus
   */
  public void setConnectStatus(BStatusBoolean v) { set(ConnectStatus, v, null); }

////////////////////////////////////////////////////////////////
// Action "reconnect"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code reconnect} action.
   * @see #reconnect()
   */
  public static final Action reconnect = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code reconnect} action.
   * @see #reconnect
   */
  public void reconnect() { invoke(reconnect, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAliyunDevices.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    //endregion Slotomatic

    //region Attributes



    private static final BIcon icon = BIcon.make("module://emalyticsHVAC/icons/pxcLogo.png");

    private Logger log = Logger.getLogger(getClass().getSimpleName());

    //endregion Attributes

    //region Constructors

    /**
     * Public parameterless constructor of the class.
     */
    public BAliyunDevices() {
    }
    //endregion Constructors

    //region Methods
    // Should be grouped by functionality rather than by scope or accessibility

    //region BComponent overrides

    /**
     * The started() method is called when a component's running state moves to true.
     * Components are started top-down, children after their parent.
     *
     * @throws Exception
     */
    @Override
    public void started() throws Exception {
        super.started();
        init();
//        Clock.Ticket ct = Clock.schedulePeriodically(this,BRelTime.make(3000),checkConnect,null);
    }

    /**
     * Callback when a property (or possibly a descendant of that property) is modified
     * on this component via one of the set methods.
     *
     * @param property
     * @param context
     */
    @Override
    public void changed(Property property, Context context) {
        if (!this.isRunning()) {
            return;
        }
    }


    private ThingSample thingTestManager = null;

    public void init(){
        DeviceInfoData deviceInfoData = new DeviceInfoData();
        deviceInfoData.region = getRegionId();
        deviceInfoData.deviceSecret = getDeviceSecret();
        deviceInfoData.deviceName = getDeviceName();
        deviceInfoData.productSecret = getProductSecret();
        deviceInfoData.productKey = getProductKey();

        LinkKitInitParams params = new LinkKitInitParams();

        /**
         * 设置 Mqtt 初始化参数
         */
        IoTMqttClientConfig config = new IoTMqttClientConfig();
        config.productKey = deviceInfoData.productKey;
        config.deviceName = deviceInfoData.deviceName;
        config.deviceSecret = deviceInfoData.deviceSecret;
        config.channelHost = deviceInfoData.productKey + ".iot-as-mqtt." + deviceInfoData.region + ".aliyuncs.com:1883";
        /**
         * 是否接受离线消息
         * 对应 mqtt 的 cleanSession 字段
         */
        config.receiveOfflineMsg = false;
        params.mqttClientConfig = config;

        /**
         * 设置初始化三元组信息，用户传入
         */
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.productKey = deviceInfoData.productKey;
        deviceInfo.deviceName = deviceInfoData.deviceName;
        deviceInfo.deviceSecret = deviceInfoData.deviceSecret;

        params.deviceInfo = deviceInfo;

        /**
         * 设置设备当前的初始状态值，属性需要和云端创建的物模型属性一致
         * 如果这里什么属性都不填，物模型就没有当前设备相关属性的初始值。
         * 用户调用物模型上报接口之后，物模型会有相关数据缓存。
         */
        Map<String, ValueWrapper> propertyValues = new HashMap<String, ValueWrapper>();
        // 示例
        // propertyValues.put("LightSwitch", new ValueWrapper.BooleanValueWrapper(0));
        params.propertyValues = propertyValues;
        params.fmVersion = "1.0.2";

        thingTestManager = new ThingSample(deviceInfo.productKey, deviceInfo.deviceName);

        LinkKit.getInstance().init(params, new ILinkKitConnectListener() {

            @Override
            public void onError(com.aliyun.alink.linksdk.tools.AError aError) {
                log.warning("Init Error error=" + aError);
            }

            @Override
            public void onInitDone(InitResult initResult) {
                log.info("onInitDone result=" + initResult);
                executeScheduler(deviceInfoData);
            }
        });

    }

    boolean testDeinit = false;
    /**
     * 定时执行
     * @param deviceInfoData
     */
    public void executeScheduler(DeviceInfoData deviceInfoData) {
//         定时上报
        ThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                thingTestManager.report();
            }
        }, 3, 5, TimeUnit.SECONDS);
    }

    private void deinit(){
        LinkKit.getInstance().deinit();
    }

    /**
     * 测试 Mqtt 基础topic封装
     * 发布
     * 订阅
     * 取消订阅
     * 注册资源监听，一般用于服务
     */
    private void testMqtt(){
        MqttSample sample = new MqttSample(getProductKey(), getDeviceName());
        sample.publish();
        sample.subscribe();
        sample.unSubscribe();
        sample.registerResource();
    }

    public void doCheckConnect(){

    }
    public void doReconnect(){
        deinit();
        init();

    }



    /**
     * Get the icon.
     *
     * @return The icon.
     */
    @Override
    public BIcon getIcon() {
        return icon;
    }
    //endregion BComponents overrides
    //endregion Methods
}