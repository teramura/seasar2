/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.extension.jdbc.gen.model;

import javax.persistence.TemporalType;

/**
 * プロパティのモデルです。
 * 
 * @author taedium
 */
public class PropertyModel {

    /** 名前 */
    protected String name;

    /** プロパティのクラス */
    protected Class<?> propertyClass;

    /** 識別子であれば{@code true} */
    protected boolean id;

    /** 時制の種別 */
    protected TemporalType temporalType;

    /** バージョンであれば{@code true} */
    protected boolean version;

    /** 一時的であれば{@code true} */
    protected boolean trnsient;

    /** {@code LOB}であれば{@code true} */
    protected boolean lob;

    /**
     * 名前を返します。
     * 
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 名前を設定します。
     * 
     * @param name
     *            名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * プロパティのクラスを返します。
     * 
     * @return プロパティのクラス
     */
    public Class<?> getPropertyClass() {
        return propertyClass;
    }

    /**
     * プロパティのクラスを設定します。
     * 
     * @param propertyClass
     *            プロパティのクラス
     */
    public void setPropertyClass(Class<?> propertyClass) {
        this.propertyClass = propertyClass;
    }

    /**
     * 識別子であれば{@code true}を返します。
     * 
     * @return 識別子であれば{@code true}、そうでなければ{@code false}
     */
    public boolean isId() {
        return id;
    }

    /**
     * 識別子であれば{@code true}を設定します。
     * 
     * @param id
     *            識別子であれば{@code true}
     */
    public void setId(boolean id) {
        this.id = id;
    }

    /**
     * 時制の種別を返します。
     * 
     * @return 時制の種別
     */
    public TemporalType getTemporalType() {
        return temporalType;
    }

    /**
     * 時制の種別を設定します。
     * 
     * @param temporalType
     *            時制の種別
     */
    public void setTemporalType(TemporalType temporalType) {
        this.temporalType = temporalType;
    }

    /**
     * バージョンであれば{@code true}を返します。
     * 
     * @return バージョンであれば{@code true}、そうでなければ{@code false}
     */
    public boolean isVersion() {
        return version;
    }

    /**
     * バージョンであれば{@code true}を設定します。
     * 
     * @param version
     *            バージョンであれば{@code true}
     */
    public void setVersion(boolean version) {
        this.version = version;
    }

    /**
     * 一時的であれば{@code true}を返します。
     * 
     * @return 一時的であれば{@code true}、そうでなければ{@code false}
     */
    public boolean isTransient() {
        return trnsient;
    }

    /**
     * 一時的であれば{@code true}を設定します。
     * 
     * @param trnsient
     *            一時的であれば{@code true}
     */
    public void setTransient(boolean trnsient) {
        this.trnsient = trnsient;
    }

    /**
     * {@code LOB}であれば{@code true}を返します。
     * 
     * @return {@code LOB}であれば{@code true}、そうでなければ{@code false}
     */
    public boolean isLob() {
        return lob;
    }

    /**
     * {@code LOB}であれば{@code true}を設定します。
     * 
     * @param lob
     *            {@code LOB}であれば{@code true}
     */
    public void setLob(boolean lob) {
        this.lob = lob;
    }

}