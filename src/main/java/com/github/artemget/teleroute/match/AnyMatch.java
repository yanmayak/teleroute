/*
 * MIT License
 *
 * Copyright (c) 2024 Artem Getmanskii
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

import com.github.artemget.teleroute.update.UpdWrap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Check update match any condition.
 *
 * @param <U> Telegram update, i.e. telegrambots Update or your own telegram update implementation
 * @since 0.0.0
 */
public final class AnyMatch<U> implements Match<U> {
    /**
     * Match conditions.
     */
    private final Collection<Match<U>> matches;

    /**
     * Construct AnyMatch contains one or many conditions.
     *
     * @param matches Conditions
     */
    @SafeVarargs
    public AnyMatch(final Match<U>... matches) {
        this(Arrays.asList(matches));
    }

    /**
     * Main constructor. Construct AnyMatch contains many conditions.
     *
     * @param matches Conditions
     */
    public AnyMatch(final Collection<Match<U>> matches) {
        this.matches = Collections.unmodifiableCollection(matches);
    }

    @Override
    public Boolean match(final UpdWrap<U> update) {
        final boolean matched;
        if (this.matches.isEmpty()) {
            matched = true;
        } else {
            matched = this.matches
                .stream()
                .anyMatch(match -> match.match(update));
        }
        return matched;
    }
}
