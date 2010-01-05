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
package example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

/**
 * 住所
 * 
 * @author taedium
 */
@Entity
public class Address {

    /** 識別子 */
    @Id
    @TableGenerator(name = "generator")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
    public Integer id;

    /** 都市 */
    public String city;

    /** 従業員 */
    @OneToOne(mappedBy = "address")
    public Employee employee;
}
