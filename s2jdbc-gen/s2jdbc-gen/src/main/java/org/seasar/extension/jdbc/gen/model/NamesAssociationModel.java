/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
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

/**
 * 名前クラスの関連モデルです。
 * 
 * @author taedium
 */
public class NamesAssociationModel {

    /** 名前 */
    protected String name;

    /** 関連のプロパティ名クラスの名前 */
    protected String className;

    /** 関連のプロパティ名を表すクラスの単純名 */
    protected String shortClassName;

    /**
     * 名前を返します
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
     * 関連のプロパティ名クラスの名前を返します。
     * 
     * @return 関連のプロパティ名クラスの名前
     */
    public String getClassName() {
        return className;
    }

    /**
     * 関連のプロパティ名クラスの名前を設定します。
     * 
     * @param className
     *            関連のプロパティ名クラスの名前
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 関連のプロパティ名を表すクラスの単純名を返します。
     * 
     * @return 関連のプロパティ名を表すクラスの単純名
     */
    public String getShortClassName() {
        return shortClassName;
    }

    /**
     * 関連のプロパティ名を表すクラスの単純名を設定します。
     * 
     * @param shortClassName
     *            関連のプロパティ名を表すクラスの単純名
     */
    public void setShortClassName(String shortClassName) {
        this.shortClassName = shortClassName;
    }

}
