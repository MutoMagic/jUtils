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

/**
 * 此类有助于验证参数。验证方法基于以下几个原则：
 * <ul>
 * <li>无效的 {@code null} 会引发 {@link NullPointerException}</li>
 * <li>非空参数会导致 {@link IllegalArgumentException}</li>
 * <li>Array/Collection/Map/String 中的无效索引会触发 {@link IndexOutOfBoundsException}</li>
 * </ul>
 *
 * <p>所有异常消息都是Java平台定义的
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax">格式字符串</a>
 * 。例如：</p>
 *
 * <pre>
 * Validate.isTrue(i &gt; 0, "值必须大于零：%d", i);
 * </pre>
 *
 * @author muto
 * @see String#format(String, Object...)
 * @since 1.0
 */
public class Validate {

    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "表达式不成立";

    // isTrue
    //-----------------------------------------------------------------------

    /**
     * 验证表达式是否为 {@code true}，否则将引发指定消息的异常。根据任意表达式进行验证时，该方法非常有用！
     *
     * @param expression 待验证的表达式
     * @param message
     * @param values
     * @throws IllegalArgumentException
     */
    public static void isTrue(final boolean expression, final String message, final Object... values) {
        if (!expression) {
            throw new IllegalArgumentException(message != null ? String.format(message, values)
                    : DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

}
