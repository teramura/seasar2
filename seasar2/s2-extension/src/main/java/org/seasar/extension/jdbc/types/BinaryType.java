/*
 * Copyright 2004-2015 the Seasar Foundation and the Others.
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
package org.seasar.extension.jdbc.types;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.seasar.extension.jdbc.ValueType;
import org.seasar.extension.jdbc.util.BindVariableUtil;

/**
 * Binary用の {@link ValueType}です。
 * 
 * @author higa
 * 
 */
public class BinaryType extends AbstractValueType {

    /**
     * インスタンスを構築します。
     */
    public BinaryType() {
        super(Types.BINARY);
    }

    public Object getValue(ResultSet resultSet, int index) throws SQLException {
        try {
            return toByteArray(resultSet.getBlob(index));
        } catch (SQLException e) {
            return resultSet.getBytes(index);
        }
    }

    public Object getValue(ResultSet resultSet, String columnName)
            throws SQLException {
        try {
            return toByteArray(resultSet.getBlob(columnName));
        } catch (SQLException e) {
            return resultSet.getBytes(columnName);
        }
    }

    public Object getValue(CallableStatement cs, int index) throws SQLException {
        try {
            return toByteArray(cs.getBlob(index));
        } catch (SQLException e) {
            return cs.getBytes(index);
        }
    }

    public Object getValue(CallableStatement cs, String parameterName)
            throws SQLException {
        try {
            return toByteArray(cs.getBlob(parameterName));
        } catch (SQLException e) {
            return cs.getBytes(parameterName);
        }
    }

    private byte[] toByteArray(Blob blob) throws SQLException {
        if (blob == null) {
            return null;
        }
        long l = blob.length();
        if (Integer.MAX_VALUE < l) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return blob.getBytes(1, (int) l);
    }

    public void bindValue(PreparedStatement ps, int index, Object value)
            throws SQLException {

        if (value == null) {
            setNull(ps, index);
        } else if (value instanceof byte[]) {
            byte[] ba = (byte[]) value;
            InputStream in = new ByteArrayInputStream(ba);
            ps.setBinaryStream(index, in, ba.length);
        } else {
            ps.setObject(index, value);
        }
    }

    public void bindValue(CallableStatement cs, String parameterName,
            Object value) throws SQLException {

        if (value == null) {
            setNull(cs, parameterName);
        } else if (value instanceof byte[]) {
            byte[] ba = (byte[]) value;
            InputStream in = new ByteArrayInputStream(ba);
            cs.setBinaryStream(parameterName, in, ba.length);
        } else {
            cs.setObject(parameterName, value);
        }
    }

    public String toText(Object value) {
        if (value == null) {
            return BindVariableUtil.nullText();
        } else if (value instanceof byte[]) {
            return BindVariableUtil.toText((byte[]) value);
        }
        return BindVariableUtil.toText(value);
    }
}