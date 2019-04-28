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
 * 字符串工具
 *
 * @author muto
 * @since 1.0
 */
public class StringUtils {

    public static final String EMPTY = "";

    public static final String NULL_STRING = "" + null;

    public static final String SPACE = " ";

    public static final String LF = "\n"; // Linux

    public static final String CR = "\r"; // MAC OS

    public static final String CRLF = "\r\n"; // Windows

    // 空值检查
    //-----------------------------------------------------------------------

    /**
     * 检查字符序列是否为空
     *
     * <pre>
     * StringUtils.isEmpty(null)       = true
     * StringUtils.isEmpty("")         = true
     * StringUtils.isEmpty(" ")        = false
     * StringUtils.isEmpty("alex")     = false
     * StringUtils.isEmpty("  alex  ") = false
     * </pre>
     *
     * @param cs 需要检查的字符序列，可以为null
     * @return 当字符序列为空时返回 {@code true}
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 检查字符序列是否为空白
     *
     * <pre>
     * StringUtils.isEmpty(null)       = true
     * StringUtils.isEmpty("")         = true
     * StringUtils.isEmpty(" ")        = true
     * StringUtils.isEmpty("alex")     = false
     * StringUtils.isEmpty("  alex  ") = false
     * </pre>
     *
     * @param cs 需要检查的字符序列，可以为null
     * @return 当字符序列为空白时返回 {@code true}
     */
    public static boolean isBlank(final CharSequence cs) {
        int length;
        if (cs == null || (length = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(cs.charAt(i))
            ) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    //-----------------------------------------------------------------------

    /**
     * 首字母大写
     *
     * @param str 需要大写的字符串，可以为null
     * @return 大写后的字符串，当 {@code str} 为null时返回 {@code null}
     */
    public static String capitalize(final String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }

        char[] ca = str.toCharArray();
        // 字母 A 并不是 TitleCase
        if (Character.isUpperCase(ca[0]) || !Character.isLetter(ca[0])
        ) {
            return str;
        }

        ca[0] -= 32;
        return new String(ca);
    }

}
