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

package com.moebuff.jutils.lang.reflect;

import java.lang.reflect.Field;

/**
 * 通过反射使用 {@link java.lang.reflect.Field Fields} 的实用程序。
 *
 * @author muto
 * @since 1.0
 */
public class FieldUtils {

    public static Field getField(Class<?> cls, String fieldName) {
        return FieldUtils.getField(cls, fieldName, true);
    }

    public static Field getDeclaredField(Class<?> cls, String fieldName) {
        return FieldUtils.getDeclaredField(cls, fieldName, true);
    }

}
