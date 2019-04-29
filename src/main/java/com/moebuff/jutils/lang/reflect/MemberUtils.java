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

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/**
 * 包含用于处理 {@link java.lang.reflect.Member Members} 的通用代码。
 *
 * @author muto
 * @since 1.0
 */
public class MemberUtils {

    /**
     * 检查 {@link Member} 是否包含 {@code final} 修饰符
     *
     * @param m 待检查的成员
     * @return 当 {@code m} 被 {@code final} 修饰后返回 {@code true}
     */
    public static boolean isFinal(final Member m) {
        return m != null && Modifier.isFinal(m.getModifiers());
    }

    /**
     * 检查 {@link Member} 是否允许被访问
     *
     * @param m 待检查的成员
     * @return 当 {@code m} 允许被访问时返回 {@code true}
     */
    public static boolean isAccessible(final Member m) {
        return m != null && Modifier.isPublic(m.getModifiers()) && !m.isSynthetic();
    }

}
