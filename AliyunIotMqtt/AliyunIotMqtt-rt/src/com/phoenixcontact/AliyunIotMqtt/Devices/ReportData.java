package com.phoenixcontact.AliyunIotMqtt.Devices;

import com.aliyun.alink.linkkit.api.ILinkKit;
import com.aliyun.alink.linkkit.api.LinkKit;
import com.aliyun.alink.linksdk.tmp.device.payload.ValueWrapper;

import java.util.HashMap;

public class  ReportData {
    public  HashMap<String, ValueWrapper> ReportDataWrapperMap = new HashMap<String, ValueWrapper>();


    public static ReportData getInstance() {
        return ReportData.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ReportData INSTANCE = new ReportData();

        private SingletonHolder() {
        }
    }

}
