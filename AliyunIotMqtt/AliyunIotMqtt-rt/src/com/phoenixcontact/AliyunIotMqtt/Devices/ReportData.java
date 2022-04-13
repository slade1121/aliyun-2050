package com.phoenixcontact.AliyunIotMqtt.Devices;

import com.aliyun.alink.linkkit.api.ILinkKit;
import com.aliyun.alink.linkkit.api.LinkKit;
import com.aliyun.alink.linksdk.tmp.device.payload.ValueWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class  ReportData {
    public Map<String, ValueWrapper> ReportDataWrapperMap = new ConcurrentHashMap<String, ValueWrapper>();


    public static ReportData getInstance() {
        return ReportData.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ReportData INSTANCE = new ReportData();

        private SingletonHolder() {
        }
    }

}
