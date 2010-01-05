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
package org.seasar.framework.container.external;

import org.seasar.framework.container.ComponentDef;
import org.seasar.framework.container.ContainerConstants;
import org.seasar.framework.container.impl.SimpleComponentDef;

/**
 * requestスコープ用の {@link ComponentDef}です。
 * 
 * @author higa
 * 
 */
public class RequestMapComponentDef extends SimpleComponentDef {

    /**
     * {@link RequestMapComponentDef}を作成します。
     */
    public RequestMapComponentDef() {
        super(null, null, ContainerConstants.REQUEST_SCOPE);
    }

    /**
     * @see org.seasar.framework.container.ComponentDef#getComponent()
     */
    public Object getComponent() {
        return getContainer().getRoot().getExternalContext().getRequestMap();
    }
}