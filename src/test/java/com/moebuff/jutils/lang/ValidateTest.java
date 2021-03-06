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

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidateTest {

    @Nested
    class testIsTrue {

        @Test
        void shouldNotThrow() {
            Validate.isTrue(true, "MSG");
            Validate.isTrue(true);
        }

        @Test
        void withGivenMessage() {
            final IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validate.isTrue(false, "MSG"));
            assertEquals("MSG", ex.getMessage());
        }

        @Test
        void defaultMessage() {
            final IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> Validate.isTrue(false));
            assertEquals("表达式不成立", ex.getMessage());
        }

    }

    @Nested
    class testNotNull {

        @Test
        void shouldNotThrow() {
            final Object obj = new Object();
            Validate.notNull(obj, "MSG");
            Validate.notNull(obj);
        }

        @Test
        void withGivenMessage() {
            final NullPointerException ex = assertThrows(
                    NullPointerException.class,
                    () -> Validate.notNull(null, "MSG"));
            assertEquals("MSG", ex.getMessage());
        }

        @Test
        void defaultMessage() {
            final NullPointerException ex = assertThrows(
                    NullPointerException.class,
                    () -> Validate.notNull(null));
            assertEquals("验证的对象为空", ex.getMessage());
        }

    }

    @Nested
    class testNotEmpty {

        @Test
        void shouldNotThrow() {
            final Object[] array = new Object[]{null};
            Validate.notEmpty(array, "MSG");
            Validate.notEmpty(array);
        }

    }

}
