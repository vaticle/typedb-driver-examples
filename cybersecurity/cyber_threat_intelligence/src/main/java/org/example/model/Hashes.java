/*
 * Copyright (C) 2023 Vaticle
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Hashes {

    private String hash_algorithm;

    @JsonIgnore
    private String typeString = " hash_algorithm;";

    @JsonIgnore
    private String rolePlayers = " hash_value; hashes_owner;";

    public String getTypeString() {
        return typeString;
    }

    public String getRolePlayers() {
        return rolePlayers;
    }

    public String getHash_algorithm() {
        return hash_algorithm;
    }

    public void setHash_algorithm(String hash_algorithm) {
        this.hash_algorithm = hash_algorithm;
    }
}