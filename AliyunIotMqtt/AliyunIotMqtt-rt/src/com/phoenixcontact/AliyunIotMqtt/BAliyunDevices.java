/*
 * Classname:   BAliyunDevices
 *
 * Version:     1.0
 *
 * Date:        2022/3/25
 *
 * Copyright (c) 2022 PHOENIX CONTACT
 */

package com.phoenixcontact.AliyunIotMqtt;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
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
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
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
@NiagaraProperty(name = "deviceName", type = "BString", defaultValue = "PXC-I2050-A874-1D9E-2D9A", flags = Flags.SUMMARY)
@NiagaraProperty(name = "deviceSecret", type = "BString", defaultValue = "aa96564b4677d8863e3ae061e23e9503", flags = Flags.SUMMARY)
@NiagaraProperty(name = "regionId", type = "BString", defaultValue = "cn-shanghai", flags = Flags.SUMMARY)
@NiagaraProperty(name = "port", type = "int", defaultValue = "1883", flags = Flags.SUMMARY)
@NiagaraProperty(name = "signmethod", type = "BSignMethodEnum", defaultValue = "BSignMethodEnum.hmacsha256", flags = Flags.SUMMARY)
@NiagaraProperty(name = "securemode", type = "int", defaultValue = "2", flags = Flags.SUMMARY)
@NiagaraProperty(name = "pubTopic", type = "BString", defaultValue = " ", flags = Flags.READONLY)
@NiagaraProperty(name = "ConnectStatus", type = "BStatusBoolean", defaultValue = "new BStatusBoolean(false)", flags = Flags.READONLY)
@NiagaraAction(name = "reconnect", flags = Flags.SUMMARY)
@NiagaraAction(name = "disConnect", flags = Flags.SUMMARY)
@NiagaraAction(name = "checkConnect", flags = Flags.HIDDEN)

//javax.baja.sys.TypeException: java.lang.NoClassDefFoundError: org/eclipse/paho/client/mqttv3/MqttException AliyunIotMqtt:AliyunDevices=com.phoenixcontact.AliyunIotMqtt.BAliyunDevices
public class BAliyunDevices extends BComponent {
    //region Slotomatic

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.phoenixcontact.AliyunIotMqtt.BAliyunDevices(1524958793)1.0$ @*/
/* Generated Tue Apr 05 11:52:08 CST 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "signmethod"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code signmethod} property.
   * @see #getSignmethod
   * @see #setSignmethod
   */
  public static final Property signmethod = newProperty(Flags.SUMMARY, BSignMethodEnum.hmacsha256, null);
  
  /**
   * Get the {@code signmethod} property.
   * @see #signmethod
   */
  public BSignMethodEnum getSignmethod() { return (BSignMethodEnum)get(signmethod); }
  
  /**
   * Set the {@code signmethod} property.
   * @see #signmethod
   */
  public void setSignmethod(BSignMethodEnum v) { set(signmethod, v, null); }

////////////////////////////////////////////////////////////////
// Property "securemode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code securemode} property.
   * @see #getSecuremode
   * @see #setSecuremode
   */
  public static final Property securemode = newProperty(Flags.SUMMARY, 2, null);
  
  /**
   * Get the {@code securemode} property.
   * @see #securemode
   */
  public int getSecuremode() { return getInt(securemode); }
  
  /**
   * Set the {@code securemode} property.
   * @see #securemode
   */
  public void setSecuremode(int v) { setInt(securemode, v, null); }

////////////////////////////////////////////////////////////////
// Property "pubTopic"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pubTopic} property.
   * @see #getPubTopic
   * @see #setPubTopic
   */
  public static final Property pubTopic = newProperty(Flags.READONLY, " ", null);
  
  /**
   * Get the {@code pubTopic} property.
   * @see #pubTopic
   */
  public String getPubTopic() { return getString(pubTopic); }
  
  /**
   * Set the {@code pubTopic} property.
   * @see #pubTopic
   */
  public void setPubTopic(String v) { setString(pubTopic, v, null); }

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

    private  MqttClient mqttClient = null;
    private  Random random = new Random();
    private  DecimalFormat df = new DecimalFormat("0.#");
    //高级版 物模型-属性上报payload
    private String payloadJson =
            "{" +
                    "    \"id\": %s," +
                    "    \"params\": {" +
                    "        \"CurrentTemperature\": %s," +
                    "        \"TargetTemperature\": %s," +
                    "        \"PowerSwitch\": %s" +
                    "    }," +
                    "    \"method\": \"thing.event.property.post\"" +
                    "}";

    public void init(){

        //物模型-属性上报topic
        setPubTopic("/sys/" + getProductKey() + "/" + getDeviceName() + "/thing/event/property/post");

        initAliyunIoTClient();

        ScheduledExecutorService scheduledThreadPool = new ScheduledThreadPoolExecutor(1,
                new ThreadFactoryBuilder().setNameFormat("thread-runner-%d").build());

        scheduledThreadPool.scheduleAtFixedRate(()->postDeviceProperties(), 10,10, TimeUnit.SECONDS);

    }

    private void initAliyunIoTClient() {

        try {
            String timestamp = String.valueOf(System.currentTimeMillis());

            Map<String, String> params = new HashMap<>(16);
            params.put("productKey", getProductKey());
            params.put("deviceName", getDeviceName());
            params.put("timestamp", timestamp);

            String targetServer = calculateTargetServer(getProductKey(),getRegionId(),getPort());

            String mqttclientId = calculateClientId(getDeviceName(),getProductKey(),getSecuremode(),getSignmethod().getTag().toString(),timestamp);

            String mqttUsername = calculateUserName(getDeviceName(),getProductKey());

            String mqttPassword = calculatePassword(timestamp,getDeviceName(),getProductKey(),getDeviceSecret());

            connectMqtt(targetServer, mqttclientId,mqttUsername, mqttPassword);

        } catch (Exception e) {
            log.warning("initAliyunIoTClient error " + e.getMessage());
        }
    }

    private String calculatePassword(String timestamp,String deviceName, String productKey,String deviceSecret) throws Exception {
        String plainPasswd = "clientId" + productKey + "." + deviceName + "deviceName" +
                deviceName + "productKey" + productKey + "timestamp" + timestamp;
        return hmac(plainPasswd, deviceSecret,getSignmethod().getTag().toString());
    }

    private String hmac(String plainText, String key, String algorithm) throws Exception {
        String format = null;
        switch(algorithm.toString().toLowerCase(Locale.ROOT)){
            case "hmacmd5":
                format = "%032x" ;
                break;
            case "hmacsha1":
                format = "%040x" ;
                break;
            case "hmacsha256":
                format = "%064x" ;
                break;
        }

        if (plainText == null || key == null) {
            return null;
        }

        byte[] hmacResult = null;

        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        mac.init(secretKeySpec);
        hmacResult = mac.doFinal(plainText.getBytes());
        return String.format(format, new BigInteger(1, hmacResult));
    }

    private String calculateUserName(String deviceName, String productKey){
        return  deviceName + "&" + productKey;
    }

    private String calculateClientId(String deviceName, String productKey,int securemode,String signmethod,String timestamp){
        return   productKey  + "." + deviceName + "|securemode="+ securemode + "," + "signmethod=" + signmethod +"," + "timestamp=" + timestamp + "|";
    }

    private String calculateTargetServer(String productKey, String regionId,int port){
        return  "tcp://" + productKey + ".iot-as-mqtt."+regionId+".aliyuncs.com:" + port;
    }

    public void connectMqtt(String url, String clientId, String mqttUsername, String mqttPassword) throws Exception {

        MemoryPersistence persistence = new MemoryPersistence();
        mqttClient = new MqttClient(url, clientId, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        // MQTT 3.1.1
        connOpts.setMqttVersion(4);
        connOpts.setAutomaticReconnect(false);
        connOpts.setCleanSession(true);

        connOpts.setUserName(mqttUsername);
        connOpts.setPassword(mqttPassword.toCharArray());
        connOpts.setKeepAliveInterval(60);

        mqttClient.connect(connOpts);

    }

    private void postDeviceProperties() {

        //publish data
        try {
            String payload = String.format(payloadJson, System.currentTimeMillis(), df.format(25+random.nextFloat()*10), df.format(20+random.nextFloat()*10), df.format(1));
//            System.out.println("post :"+payload);
            MqttMessage message = new MqttMessage(payload.getBytes(StandardCharsets.UTF_8));
            message.setQos(1);
            mqttClient.publish(getPubTopic(), message);
        } catch (Exception e) {
            log.warning(e.getStackTrace().toString());
        }

    }

    public void doReconnect(){
        if(!mqttClient.isConnected()){
            init();
        }
    }
    public void doDisConnect(){
        if(mqttClient.isConnected()){
            try {
                mqttClient.disconnect();
            }catch (Exception e){
                log.warning(e.getStackTrace().toString());
            }
        }
    }


    public void doCheckConnect(){
        setConnectStatus(new BStatusBoolean(mqttClient.isConnected()));
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