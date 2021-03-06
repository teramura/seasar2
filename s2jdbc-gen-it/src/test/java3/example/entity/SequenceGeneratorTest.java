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
package example.entity;

import javax.transaction.UserTransaction;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.unit.S2TestCase;

/**
 * @author taedium
 * 
 */
public class SequenceGeneratorTest extends S2TestCase {

    private JdbcManager jdbcManager;

    private UserTransaction userTransaction;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        include("s2jdbc.dicon");
    }

    /**
     * 
     * @throws Exception
     */
    public void test() throws Exception {
        userTransaction.begin();

        Address address = new Address();
        address.city = "TOKYO";
        jdbcManager.insert(address).execute();

        Department department = new Department();
        department.name = "SALES";
        jdbcManager.insert(department).execute();

        Employee employee = new Employee();
        employee.firstName = "John";
        employee.age = 30;
        employee.addressId = address.id;
        employee.departmentId = department.id;
        jdbcManager.insert(employee).execute();

        userTransaction.commit();
    }
}
