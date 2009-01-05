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
package org.seasar.framework.container.cooldeploy.creator;

import org.seasar.framework.container.cooldeploy.creator.service.impl.GggServiceImpl;
import org.seasar.framework.unit.S2FrameworkTestCase;

/**
 * @author higa
 * 
 */
public class ServiceCoolCreatorTest extends S2FrameworkTestCase {

    /**
     * 
     */
    public ServiceCoolCreatorTest() {
        setWarmDeploy(false);
    }

    protected void setUp() {
        include("ServiceCoolCreatorTest.dicon");
    }

    /**
     * @throws Exception
     */
    public void testAll() throws Exception {
        assertTrue(getContainer().hasComponentDef("ccc_dddService"));
        assertTrue(getContainer().hasComponentDef("gggService"));
        assertFalse(getContainer().hasComponentDef(
                GggServiceImpl.InnerServiceImpl.class));
    }
}