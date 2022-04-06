/*
 * Classname:   BSignMethodEnum
 *
 * Version:     1.0
 *
 * Date:        2022/4/5
 *
 * Copyright (c) 2022 PHOENIX CONTACT
 */

package com.phoenixcontact.AliyunIotMqtt;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * TODO Description
 *
 * @author
 * @version 1.0
 * @since 2022/4/5
 */

@NiagaraEnum
        (
                range = {
                        @Range("hmacsha256"),
                        @Range("hmacsha1"),
                        @Range("hmacmd5")
                },
                defaultValue = "hmacsha256"
        )
@NiagaraType
public final class BSignMethodEnum extends BFrozenEnum {
    //region Slotomatic   
    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

    /** Ordinal value for hmacsha256. */
    public static final int Enum_hmacsha256 = 0;
    /** Ordinal value for hmacsha1. */
    public static final int Enum_hmacsha1 = 1;
    /** Ordinal value for hmacmd5. */
    public static final int Enum_hmacmd5 = 2;

    /** BSignMethodEnum constant for hmacsha256. */
    public static final BSignMethodEnum hmacsha256 = new BSignMethodEnum(Enum_hmacsha256);
    /** BSignMethodEnum constant for hmacsha1. */
    public static final BSignMethodEnum hmacsha1 = new BSignMethodEnum(Enum_hmacsha1);
    /** BSignMethodEnum constant for hmacmd5. */
    public static final BSignMethodEnum hmacmd5 = new BSignMethodEnum(Enum_hmacmd5);

    /** Private constructor. */
    private BSignMethodEnum(int ordinal)
    {
        super(ordinal);
    }


    /** Factory method with ordinal. */
    public static BSignMethodEnum make(int ordinal)
    {
        return (BSignMethodEnum)hmacmd5.getRange().get(ordinal, false);
    }

    /** Factory method with tag. */
    public static BSignMethodEnum make(String tag)
    {
        return (BSignMethodEnum)hmacmd5.getRange().get(tag);
    }

    public static final BSignMethodEnum DEFAULT = hmacsha256;

    @Override
    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BSignMethodEnum.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    //endregion Slotomatic
}