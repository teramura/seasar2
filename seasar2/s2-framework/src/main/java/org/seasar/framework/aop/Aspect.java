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
package org.seasar.framework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Aspectをあらわすインターフェースです。 Aspectとは、 Advice({@link MethodInterceptor})と{@link Pointcut}を結びつけたものです。
 * 
 * @author higa
 * 
 */
public interface Aspect {

    /**
     * {@link MethodInterceptor}を返します。
     * 
     * @return {@link MethodInterceptor}
     */
    MethodInterceptor getMethodInterceptor();

    /**
     * {@link Pointcut}を返します。
     * 
     * @return
     */
    Pointcut getPointcut();

    /**
     * {@link Pointcut}を設定します。
     * 
     * @param pointcut
     */
    void setPointcut(Pointcut pointcut);

}
