/*
 *  The MIT License
 *
 *  Copyright 2013 rinrinne. All rights reserved.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

// Created by jia.jia@zte.com.cn

package com.sonyericsson.hudson.plugins.gerrit.trigger.hudsontrigger.data;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Represents a rule for triggering on a email of a GerritProject.
 * @author rinrinne &lt;rinrin.ne@gmail.com&gt;
 */
public class Email extends AbstractDescribableImpl<Email> {

    private CompareType compareType;
    private String pattern;

    /**
     * Default empty constructor.
     */
    public Email() {
    }

    /**
     * Default DataBound constructor.
     * @param compareType the CompareType to use when comparing with the pattern.
     * @param pattern the pattern to match on.
     */
    @DataBoundConstructor
    public Email(CompareType compareType, String pattern) {
        this.compareType = compareType;
        this.pattern = pattern;
    }

    /**
     * The CompareType used.
     * @return the CompareType
     */
    public CompareType getCompareType() {
        return compareType;
    }

    /**
     * The CompareType used.
     * @param compareType the compareType.
     */
    public void setCompareType(CompareType compareType) {
        this.compareType = compareType;
    }

    /**
     * The pattern to match on.
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * The pattern to match on.
     * @param pattern the pattern.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Tells if the given email are matched by this rule.
     * @param email the email in change.
     * @return true if the email match.
     */
    public boolean isInteresting(String email) {
        if (email == null) {
            email = "";
        }

        String[] list = pattern.split(" ");
        for (String p : list) {
            if (p.equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    /**
     * The Descriptor for the Email.
     */
    @Extension
    public static class DescriptorImpl extends Descriptor<Email> {
        @Override
        public String getDisplayName() {
            return "";
        }
    }
}
