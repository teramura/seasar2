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
package org.seasar.extension.dataset.types;

import junit.framework.TestCase;

/**
 * @author manhole
 * 
 */
public class BooleanTypeTest extends TestCase {

    /**
     * @throws Exception
     */
    public void testEquals() throws Exception {
        BooleanType type = new BooleanType();
        assertEquals(true, type.equals(Boolean.TRUE, Boolean.TRUE));
        assertEquals(true, type.equals(Boolean.FALSE, Boolean.FALSE));
        assertEquals(true, type.equals(null, null));
        assertEquals(false, type.equals(Boolean.TRUE, Boolean.FALSE));
        assertEquals(false, type.equals(Boolean.FALSE, Boolean.TRUE));
        assertEquals(false, type.equals(Boolean.FALSE, null));
        assertEquals(false, type.equals(Boolean.TRUE, null));
        assertEquals(false, type.equals(null, Boolean.FALSE));
        assertEquals(false, type.equals(null, Boolean.TRUE));
    }

}
