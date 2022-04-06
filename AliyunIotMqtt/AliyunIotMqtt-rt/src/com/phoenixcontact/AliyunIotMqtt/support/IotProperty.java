package com.phoenixcontact.AliyunIotMqtt.support;

import com.tridium.json.JSONObject;

public class IotProperty {
    public static IotProperty CREATE(JSONObject json) {
        return new IotProperty(json.getString("identifier"),
                json.getString("name"),
                json.getString("accessMode"),
                json.getBoolean("required"),
                json.getJSONObject("dataType").getString("type")
        );
    }


    public IotProperty(String identifier, String name, String accessMode, boolean required, String dataType) {
        this.identifier = identifier;
        this.name = name;
        this.accessMode = AccessMode.valueOf(accessMode);
        this.required = required;
        this.dataType = dataType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccessMode getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(AccessMode accessMode) {
        this.accessMode = accessMode;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    String identifier;
    String name;
    AccessMode accessMode;
    boolean required;
    String dataType;//TODO...



}
