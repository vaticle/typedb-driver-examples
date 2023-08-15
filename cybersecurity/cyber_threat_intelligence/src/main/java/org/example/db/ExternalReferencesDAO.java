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

package org.example.db;


import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.model.ExternalReferences;

public class ExternalReferencesDAO {
    private final TypeDBSessionWrapper db;
    private final ExternalReferences external_references;

    private final String nameRel = "external_references";
    private final String typeString;

    protected static final String EXTERNAL_REFERENCES_MATCH =
            "$ta (referencing: $AAA, referenced: $BBB) isa external_references;";

    public ExternalReferencesDAO(TypeDBSessionWrapper db) {
        this.db = db;
        external_references = new ExternalReferences();
        typeString = external_references.getTypeString();
    }

    private ObjectNode getJSON(String getQueryStr) {
        return db.getListJSON(getQueryStr, nameRel ,external_references.getRolePlayers());
    }

    public ObjectNode getAllJSON() {
        var getQueryStr = "match " + EXTERNAL_REFERENCES_MATCH + "group $ta; ";
        return getJSON(getQueryStr);
    }

    public ObjectNode getSearchJSON(String attrType, String attrName) {

        if (typeString.contains(" " + attrType + ";")){
            attrName = "\"" + attrName + "\"";
        }

        String search = "$ta has " + attrType + " = " + attrName + ";";
        var getQueryStr = "match " + EXTERNAL_REFERENCES_MATCH + search + "group $ta;";

        return getJSON(getQueryStr);
    }

}