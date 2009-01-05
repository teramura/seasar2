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
package org.seasar.extension.jdbc.gen.internal.desc;

import org.seasar.extension.jdbc.gen.desc.CompositeUniqueConstraintDesc;
import org.seasar.extension.jdbc.gen.desc.CompositeUniqueConstraintDescFactory;
import org.seasar.extension.jdbc.gen.meta.DbUniqueKeyMeta;

/**
 * {@link CompositeUniqueConstraintDescFactory}の実装クラスです。
 * 
 * @author taedium
 */
public class CompositeUniqueConstraintDescFactoryImpl implements
        CompositeUniqueConstraintDescFactory {

    public CompositeUniqueConstraintDesc getCompositeUniqueConstraintDesc(
            DbUniqueKeyMeta uniqueKeyMeta) {
        if (uniqueKeyMeta.isPrimaryKey() || !uniqueKeyMeta.isComposite()) {
            return null;
        }
        CompositeUniqueConstraintDesc compositeUniqueConstraintDesc = new CompositeUniqueConstraintDesc();
        for (String columnName : uniqueKeyMeta.getColumnNameList()) {
            compositeUniqueConstraintDesc.addColumnName(columnName);
        }
        return compositeUniqueConstraintDesc;
    }
}
