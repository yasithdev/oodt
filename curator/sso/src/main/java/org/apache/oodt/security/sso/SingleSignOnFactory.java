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


package org.apache.oodt.security.sso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Object factory for creating {@link SingleSignOn}s from class name Strings.
 * 
 * @author mattmann
 * @version $Revision$
 * 
 */
public final class SingleSignOnFactory {

  private static final Logger LOG = LoggerFactory.getLogger(SingleSignOnFactory.class
      .getName());

  @SuppressWarnings("unchecked")
  public static AbstractWebBasedSingleSignOn getWebBasedSingleSignOn(String className) {
    AbstractWebBasedSingleSignOn sso;
    Class<AbstractWebBasedSingleSignOn> clazz;

    try {
      clazz = (Class<AbstractWebBasedSingleSignOn>) Class.forName(className);
      sso = clazz.newInstance();
      return sso;
    } catch (ClassNotFoundException e) {
      LOG.error(e.getMessage());
      LOG.warn(
          "ClassNotFoundException when loading web based sso class "
              + className + " Message: " + e.getMessage());
    } catch (InstantiationException e) {
      LOG.error(e.getMessage());
      LOG.warn(
          "InstantiationException when loading web based sso class "
              + className + " Message: " + e.getMessage());
    } catch (IllegalAccessException e) {
      LOG.error(e.getMessage());
      LOG.warn(
          "IllegalAccessException when loading web based sso class "
              + className + " Message: " + e.getMessage());
    }

    return null;
  }

}
