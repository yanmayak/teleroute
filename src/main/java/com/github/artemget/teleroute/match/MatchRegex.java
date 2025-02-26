/*
 * MIT License
 *
 * Copyright (c) 2024-2025. Artem Getmanskii
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.artemget.teleroute.match;

import com.github.artemget.teleroute.update.Wrap;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Match text pattern.
 *
 * @param <U> Update
 * @since 0.3.0
 */
public final class MatchRegex<U> implements Predicate<Wrap<U>> {
    /**
     * Pattern to compare.
     */
    private final Pattern pattern;

    /**
     * Ctor.
     *
     * @param regex Regex string to compare.
     */
    public MatchRegex(final String regex) {
        this(Pattern.compile(regex));
    }

    /**
     * Main ctor.
     *
     * @param pattern Pattern to compare.
     */
    public MatchRegex(final Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean test(final Wrap<U> update) {
        return update.text()
            .map(text -> this.pattern.matcher(text).matches())
            .orElse(false);
    }
}
