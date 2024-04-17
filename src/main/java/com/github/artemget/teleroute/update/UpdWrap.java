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

package com.github.artemget.teleroute.update;

import java.util.Optional;

/**
 * Update wrapper, provide data required by routes and matches.
 * Implement on your own risk.
 *
 * @param <U> Telegram update, i.e. telegrambots Update or your own telegram update implementation
 * @since 0.0.0
 */
public interface UpdWrap<U> {
    /**
     * Provide update identity.
     *
     * @return Update identity
     */
    Integer identity();

    /**
     * Define is this update contains telegram command.
     *
     * @return Is command
     */
    Boolean isCommand();

    /**
     * Provide update's text if exists.
     *
     * @return Update's text
     */
    Optional<String> text();

    /**
     * Provide telegram update.
     *
     * @return Telegram update
     */
    U src();
}
