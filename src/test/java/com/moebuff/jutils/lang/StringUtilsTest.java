/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moebuff.jutils.lang;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testNullString() {
        assertEquals("null", StringUtils.NULL_STRING);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty(" "));
        assertFalse(StringUtils.isEmpty("alex"));
        assertFalse(StringUtils.isEmpty("  alex  "));
    }

    @Test
    public void testIsBlank() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank(" "));
        assertFalse(StringUtils.isBlank("alex"));
        assertFalse(StringUtils.isBlank("  alex  "));
    }

    @Test
    public void testCapitalize() {
        assertNull(StringUtils.capitalize(null));
        assertEquals("Alex",StringUtils.capitalize("alex"));
        assertEquals(" alex ",StringUtils.capitalize(" alex "));
        assertEquals("Alex",StringUtils.capitalize("Alex"));
        assertEquals("9Alex",StringUtils.capitalize("9Alex"));
        assertEquals("!Alex",StringUtils.capitalize("!Alex"));
        assertEquals("",StringUtils.capitalize(""));
        assertEquals(" ",StringUtils.capitalize(" "));
    }

}
