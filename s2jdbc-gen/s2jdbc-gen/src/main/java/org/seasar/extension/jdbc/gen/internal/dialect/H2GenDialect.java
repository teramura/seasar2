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
package org.seasar.extension.jdbc.gen.internal.dialect;

import java.math.BigDecimal;
import java.sql.Types;

import javax.persistence.GenerationType;

import org.seasar.extension.jdbc.gen.internal.sqltype.BinaryType;
import org.seasar.extension.jdbc.gen.internal.sqltype.DecimalType;

/**
 * H2の方言を扱うクラスです。
 * 
 * @author taedium
 */
public class H2GenDialect extends StandardGenDialect {

    /** テーブルが見つからないことを示すエラーコード */
    protected static int TABLE_NOT_FOUND_ERROR_CODE = 42102;

    /** カラムが見つからないことを示すエラーコード */
    protected static int COLUMN_NOT_FOUND_ERROR_CODE = 42122;

    /** シーケンスが見つからないことを示すエラーコード */
    protected static int SEQUENCE_NOT_FOUND_ERROR_CODE = 90036;

    /**
     * インスタンスを構築します。
     */
    public H2GenDialect() {
        sqlTypeMap.put(Types.BINARY, new BinaryType("binary($l)"));
        sqlTypeMap.put(Types.DECIMAL, new DecimalType("decimal($p,$s)"));

        columnTypeMap.put("binary", H2ColumnType.BINARY);
        columnTypeMap.put("decimal", H2ColumnType.DECIMAL);
        columnTypeMap.put("uuid", H2ColumnType.UUID);
        columnTypeMap
                .put("varchar_ignorecase", H2ColumnType.VARCHAR_IGNORECASE);
    }

    @Override
    public String getName() {
        return "h2";
    }

    @Override
    public String getDefaultSchemaName(String userName) {
        return null;
    }

    @Override
    public GenerationType getDefaultGenerationType() {
        return GenerationType.IDENTITY;
    }

    @Override
    public boolean supportsSequence() {
        return true;
    }

    @Override
    public String getSequenceDefinitionFragment(String dataType,
            long initialValue, int allocationSize) {
        return "start with " + initialValue + " increment by " + allocationSize;
    }

    @Override
    public String getIdentityColumnDefinition() {
        return "generated by default as identity";
    }

    @Override
    public boolean isTableNotFound(Throwable throwable) {
        Integer errorCode = getErrorCode(throwable);
        return errorCode != null
                && errorCode.intValue() == TABLE_NOT_FOUND_ERROR_CODE;
    }

    @Override
    public boolean isColumnNotFound(Throwable throwable) {
        Integer errorCode = getErrorCode(throwable);
        return errorCode != null
                && errorCode.intValue() == COLUMN_NOT_FOUND_ERROR_CODE;
    }

    @Override
    public boolean isSequenceNotFound(Throwable throwable) {
        Integer errorCode = getErrorCode(throwable);
        return errorCode != null
                && errorCode.intValue() == SEQUENCE_NOT_FOUND_ERROR_CODE;
    }

    @Override
    public boolean supportsIdentityInsert() {
        return true;
    }

    @Override
    public boolean supportsIdentity() {
        return true;
    }

    @Override
    public String getSequenceNextValString(String sequenceName,
            int allocationSize) {
        return "call next value for " + sequenceName;
    }

    @Override
    public boolean supportsCommentInCreateTable() {
        return false;
    }

    @Override
    public boolean supportsCommentOn() {
        return true;
    }

    /**
     * H2用の{@link ColumType}の実装です。
     * 
     * @author taedium
     */
    public static class H2ColumnType extends StandardColumnType {

        private static H2ColumnType BINARY = new H2ColumnType("binary($l)",
                byte[].class);

        private static H2ColumnType DECIMAL = new H2ColumnType(
                "decimal($p,$s)", BigDecimal.class);

        private static H2ColumnType UUID = new H2ColumnType("uuid",
                byte[].class);

        private static H2ColumnType VARCHAR_IGNORECASE = new H2ColumnType(
                "varchar_ignorecase", String.class);

        /**
         * インスタンスを構築します。
         * 
         * @param dataType
         *            データ型
         * @param attributeClass
         *            属性のクラス
         */
        public H2ColumnType(String dataType, Class<?> attributeClass) {
            super(dataType, attributeClass);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param dataType
         *            データ型
         * @param attributeClass
         *            属性のクラス
         * @param lob
         *            LOBの場合{@code true}
         */
        public H2ColumnType(String dataType, Class<?> attributeClass,
                boolean lob) {
            super(dataType, attributeClass, lob);
        }

    }
}
