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
 * Validate.notNull(obj, "参数不能为空");
 * </pre>
 *
 * @see String#format(String, Object...)
 * @since 1.0
 */
public class Validate {

    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "表达式不成立";
    private static final String DEFAULT_NOT_NULL_EX_MESSAGE = "验证的对象为空";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "验证的数组为空";

    // isTrue
    //-----------------------------------------------------------------------

    /**
     * 验证表达式是否为 {@code true}，否则将引发指定消息的异常。根据任意表达式进行验证时，该方法非常有用！
     *
     * @param expression 待验证的表达式
     * @param message    异常消息
     * @param values     附加到异常消息的值
     * @throws IllegalArgumentException 如果表达式为 {@code false}
     */
    public static void isTrue(final boolean expression, final String message, final Object... values) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }

    public static void isTrue(final boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    // notNull
    //-----------------------------------------------------------------------

    /**
     * 验证参数不是 {@code null} 否则将引发指定消息的异常。
     *
     * @param obj     待验证的参数
     * @param message 异常消息
     * @param values  附加到异常消息的值
     * @param <T>     参数 {@code obj} 的类型
     */
    public static <T> void notNull(final T obj, final String message, final Object... values) {
        if (obj == null) {
            throw new NullPointerException(String.format(message, values));
        }
    }

    public static <T> void notNull(final T obj) {
        if (obj == null) {
            throw new NullPointerException(DEFAULT_NOT_NULL_EX_MESSAGE);
        }
    }

    // notEmpty array
    //-----------------------------------------------------------------------

    public static <T> void notEmpty(final T[] array, final String message, final Object... values) {
        if (array == null) {
            throw new NullPointerException(String.format(message, values));
        }
        if (array.length == 0) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }

    public static <T> void notEmpty(final T[] array) {
        notEmpty(array, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE);
    }

}
