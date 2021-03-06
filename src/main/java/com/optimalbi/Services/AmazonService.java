package com.optimalbi.Services;

/*
   Copyright 2015 OptimalBI

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */


import com.optimalbi.Controller.Containers.AmazonCredentials;
import com.optimalbi.SimpleLog.*;

/**
 * This is a local representation of a AWS Service
 * @author Timothy Gray
 */
public abstract class AmazonService implements Service {

    private final AmazonCredentials credentials;
    private final Logger logger;
    private final String id;

    AmazonService(String id, AmazonCredentials credentials, Logger logger) {
        this.id = id;
        this.credentials = credentials;
        this.logger = logger;

    }

    static String stringCap(String text) {
        int maxChars = 99;
        char[] chars = text.toCharArray();
        if (chars.length > 0) {
            chars[0] = Character.toUpperCase(chars[0]);
        } else return "";
        String shortString = String.valueOf(chars);
        if (shortString.length() > maxChars) {
            shortString = shortString.substring(0, maxChars - 3);
            shortString = shortString + "...";
        }
        return shortString;
    }

    /**
     * {@inheritDoc}
     */
    public String serviceID() {
        String testString = id;
        if (testString.length() > 21) {
            testString = testString.substring(0, 21);
            testString = testString + "...";
        }
        return testString;
    }

    public int compareTo(Service o) {
        if(this.serviceName() == null){
            return -1;
        } else {
            return this.serviceName().compareTo(o.serviceName());
        }
    }

    protected Logger getLogger(){
        return logger;
    }

    /*
     * {@inheritDoc}
     */
    AmazonCredentials getCredentials() {
        return credentials;
    }
}
