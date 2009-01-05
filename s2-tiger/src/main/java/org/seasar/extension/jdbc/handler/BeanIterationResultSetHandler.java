/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.seasar.extension.jdbc.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.seasar.extension.jdbc.DbmsDialect;
import org.seasar.extension.jdbc.IterationCallback;
import org.seasar.extension.jdbc.IterationContext;
import org.seasar.extension.jdbc.ResultSetHandler;
import org.seasar.extension.jdbc.exception.SNonUniqueResultException;

/**
 * 問い合わせ結果をBeanにして反復する{@link ResultSetHandler}です。
 * 
 * @author koichik
 */
@SuppressWarnings("unchecked")
public class BeanIterationResultSetHandler extends AbstractBeanResultSetHandler {

    /** リミット */
    protected int limit;

    /** 反復コールバック */
    protected IterationCallback callback;

    /**
     * {@link BeanIterationResultSetHandler}を作成します。
     * 
     * @param beanClass
     *            Beanクラス
     * @param dialect
     *            データベースの方言
     * @param sql
     *            SQL
     * @param limit
     *            リミット
     * @param callback
     *            反復コールバック
     */
    public BeanIterationResultSetHandler(final Class<?> beanClass,
            final DbmsDialect dialect, final String sql, final int limit,
            final IterationCallback callback) {
        super(beanClass, dialect, sql);
        this.limit = limit;
        this.callback = callback;
    }

    public Object handle(final ResultSet rs) throws SQLException,
            SNonUniqueResultException {
        final IterationContext iterationContext = new IterationContext();
        Object result = null;
        for (int i = 0; (limit <= 0 || i < limit) && rs.next(); i++) {
            final Object entity = createRow(rs, createPropertyTypes(rs
                    .getMetaData()));
            result = callback.iterate(entity, iterationContext);
            if (iterationContext.isExit()) {
                return result;
            }
        }
        return result;
    }

}
