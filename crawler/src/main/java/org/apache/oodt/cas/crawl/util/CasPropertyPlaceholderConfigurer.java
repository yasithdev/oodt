/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.oodt.cas.crawl.util;

//OODT imports

import org.apache.oodt.cas.metadata.util.PathUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

//Spring imports

/**
 * 
 * @author bfoster
 * @version $Revision$
 *
 * <p>Describe your class here</p>.
 */
public class CasPropertyPlaceholderConfigurer extends
        PropertyPlaceholderConfigurer {
    private static Logger LOG = LoggerFactory.getLogger(CasPropertyPlaceholderConfigurer.class.getName());
    @Override
    protected String convertPropertyValue(String value) {
        try {
            return PathUtils.doDynamicReplacement(value);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return value;
        }
    }

}
