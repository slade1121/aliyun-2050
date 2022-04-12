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

@NiagaraProperty(name = "productKey", type = "BString", defaultValue = "gyg8zcMAPUO", flags = Flags.SUMMARY)
@NiagaraProperty(name = "productSecret", type = "BString", defaultValue = "dzri4D4eWYQJMnJu", flags = Flags.SUMMARY)
@NiagaraProperty(name = "deviceName", type = "BString", defaultValue = "PXC-I2050-A874-1D9E-2D9A", flags = Flags.SUMMARY)
@NiagaraProperty(name = "deviceSecret", type = "BString", defaultValue = "aa96564b4677d8863e3ae061e23e9503", flags = Flags.SUMMARY)
@NiagaraProperty(name = "regionId", type = "BString", defaultValue = "cn-shanghai", flags = Flags.SUMMARY)
@NiagaraProperty(name = "port", type = "int", defaultValue = "1883", flags = Flags.SUMMARY)
@NiagaraProperty(name = "ConnectStatus", type = "BStatusBoolean", defaultValue = "new BStatusBoolean(false)", flags = Flags.READONLY)
@NiagaraAction(name = "reconnect", flags = Flags.SUMMARY)
@NiagaraAction(name = "disConnect", flags = Flags.SUMMARY)
@NiagaraAction(name = "checkConnect", flags = Flags.HIDDEN)

//javax.baja.sys.TypeException: java.lang.NoClassDefFoundError: org/eclipse/paho/client/mqttv3/MqttException AliyunIotMqtt:AliyunDevices=com.phoenixcontact.AliyunIotMqtt.Devices.BAliyunDevices
public class BAliyunDevices extends BComponent {
    //region Slotomatic

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.phoenixcontact.AliyunIotMqtt.Devices.BAliyunDevices(873948881)1.0$ @*/
/* Generated Tue Apr 12 09:32:59 CST 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "productKey"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code productKey} property.
   * @see #getProductKey
   * @see #setProductKey
   */
  public static final Property productKey = newProperty(Flags.SUMMARY, "gyg8zcMAPUO", null);
  
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
  public static final Property productSecret = newProperty(Flags.SUMMARY, "dzri4D4eWYQJMnJu", null);
  
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
  public static final Property deviceName = newProperty(Flags.SUMMARY, "PXC-I2050-A874-1D9E-2D9A", null);
  
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
  public static final Property deviceSecret = newProperty(Flags.SUMMARY, "aa96564b4677d8863e3ae061e23e9503", null);
  
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
// Action "disConnect"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code disConnect} action.
   * @see #disConnect()
   */
  public static final Action disConnect = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code disConnect} action.
   * @see #disConnect
   */
  public void disConnect() { invoke(disConnect, null, null); }

////////////////////////////////////////////////////////////////
// Action "checkConnect"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code checkConnect} action.
   * @see #checkConnect()
   */
  public static final Action checkConnect = newAction(Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code checkConnect} action.
   * @see #checkConnect
   */
  public void checkConnect() { invoke(checkConnect, null, null); }

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
        Clock.Ticket ct = Clock.schedulePeriodically(this,BRelTime.make(3000),checkConnect,null);
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
        config.productKey = getProductKey();
        config.deviceName = getDeviceName();
        config.deviceSecret = getDeviceSecret();
        config.channelHost = getProductKey() + ".iot-as-mqtt." + getRegionId() + ".aliyuncs.com:1883";
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
        deviceInfo.productKey = getProductKey();
        deviceInfo.deviceName = getDeviceName();
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

        thingTestManager = new ThingSample(deviceInfoData.productKey, deviceInfoData.deviceName);
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
        thingTestManager.readData(System.getProperty("user.dir") + "/test_case.json");
//        thingTestManager.setServiceHandler();
        testMqtt();
        testLabel();
        testCota();

        // 测试网关子设备管理功能，高级版功能
//        testGateway(deviceInfoData);

        // 测试获取设备影子，基础版功能，注意不能与高级版共用
//        testDeviceShadow();
//        // test deinit
//        if (!testDeinit) {
//            testDeinit = true;
//            try {
//                Thread.sleep(5*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//           deinit();
//            HelloWorld helloWorld = new HelloWorld();
//            helloWorld.init(deviceInfoData);
//        }

//         定时上报
        ThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                thingTestManager.report();
            }
        }, 3, 5, TimeUnit.SECONDS);
    }

    private void testDeviceShadow() {
        DeviceShadowSample sample = new DeviceShadowSample();
        try {
            sample.listenDownStream();
            sample.shadowGet();
            try {
                Thread.sleep(5*1000);
            } catch (Exception e){

            }
            testMqtt();
            // 异步操作，注意别和删除操作一起执行，不能保持时序
            sample.shadowUpdate();

            // 异步操作，注意别和更新一起执行
//            sample.shadowDelete();
            // 异步操作，
//            sample.shadowDeleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        sample.shadowDelete();
    }


    /**
     * 动态注册示例代码
     * 1.现在云端创建产品和设备；
     * 2.在云端开启动态注册；
     * 3.填入pk、dn、ps；
     * 4.调用该方法；
     * 5.拿到deviceSecret返回之后 调初始化建联；
     */
    public void deviceRegister(DeviceInfo deviceInfo) {
        LinkKitInitParams params = new LinkKitInitParams();
        IoTMqttClientConfig config = new IoTMqttClientConfig();
        config.productKey = deviceInfo.productKey;
        config.deviceName = deviceInfo.deviceName;

        params.mqttClientConfig = config;
        params.connectConfig = new IoTApiClientConfig();

        params.deviceInfo = deviceInfo;

        final CommonRequest request = new CommonRequest();
        request.setPath("/auth/register/device");
        LinkKit.getInstance().deviceRegister(params, request, new IoTCallback() {
            public void onFailure(CommonRequest commonRequest, Exception e) {
                log.warning("动态注册失败 " + e);
            }

            public void onResponse(CommonRequest commonRequest, CommonResponse commonResponse) {
                if (commonResponse == null || StringUtils.isEmptyString(commonResponse.getData())) {
                   log.warning("动态注册失败 response=null");
                    return;
                }
                try {
                    ResponseModel<Map<String, String>> response = new Gson().fromJson(commonResponse.getData(), new TypeToken<ResponseModel<Map<String, String>>>() {
                    }.getType());
                    if (response != null && "200".equals(response.code)) {
                        log.warning("register success " + (commonResponse == null ? "" : commonResponse.getData()));
                        /**  获取 deviceSecret, 存储到本地，然后执行初始化建联
                         * 这个流程只能走一次，获取到 secret 之后，下次启动需要读取本地存储的三元组，
                         * 直接执行初始化建联，不可以再走动态初始化
                         */
                        // deviceSecret = response.data.get("deviceSecret");
                        // init(pk,dn,ds);
                        return;
                    }
                } catch (Exception e) {

                }
                log.warning("register fail " + commonResponse.getData());
            }
        });
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

    /**
     * 测试 COTA 远程配置
     */
    private void testCota() {
        COTASample sample = new COTASample(getProductKey(), getDeviceName());
        // 监听云端 COTA 下行数据更新
        sample.setCOTAChangeListener();
        // 获取 COTA 更新
        sample.cOTAGet();
    }

    /**
     * 标签测试
     */
    private void testLabel() {
        LabelSample sample = new LabelSample(getProductKey(), getDeviceName());
        // 测试标签更新
        sample.labelUpdate();
        // 测试标签删除
//        sample.labelDelete();
    }

    /**
     * @param deviceInfoData
     * 网关测试
     */
    private void testGateway(DeviceInfoData deviceInfoData) {
        GatewaySample sample = new GatewaySample(getProductKey(), getDeviceName(), deviceInfoData.subDevice);
        sample.getSubDevices();
        // 注册 + 添加 + 登录 + 上报
        sample.subdevRegister();

//        try {
//            Thread.sleep(10*1000);
//            // 测试下线 + 删除
//            sample.subDevOffline();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }


    public void doCheckConnect(){

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