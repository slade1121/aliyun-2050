package com.phoenixcontact.AliyunIotMqtt.Devices;

import java.io.Serializable;

public class ThingData implements Serializable {
    public String type;
    public String identifier;
    public String value;
    public String name;
    public String accessMode;
    public String required;


}