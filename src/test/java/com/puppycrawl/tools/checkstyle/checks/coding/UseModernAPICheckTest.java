///////////////////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code and other text files for adherence to a set of rules.
// Copyright (C) 2001-2025 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.checks.coding;

import static com.puppycrawl.tools.checkstyle.checks.coding.UseModernAPICheck.MSG_OUTDATED_API_USAGE;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.AbstractModuleTestSupport;

public class UseModernAPICheckTest extends AbstractModuleTestSupport {

    public static final String TO_LIST = "Collectors.toList()";
    // public static final String TO_UNMODIFIABLE_LIST = "Collectors.TO_UNMODIFIABLE_LIST()";
    // public static final String NEW_URL_STRING = "new URL(String)";
    // public static final String NEW_LOCALE_STRING_STRING = "new Locale(String, String)";
    // public static final String NEW_LOCALE_STRING = "new Locale(String)";
    // public static final String LIST_OF_STREAM = "List.of().stream()";

    @Override
    protected String getPackageLocation() {
        return "com/puppycrawl/tools/checkstyle/checks/coding/usemodernapi";
    }
    @Test
    public void simple() throws Exception {
        final String[] expected = {
            "17:9: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            "18:20: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            "19:43: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
        };
        verifyWithInlineConfigParser(getPath("InputUseModernAPISimple.java"), expected);
    }

    @Test
    public void collectors() throws Exception {
        final String[] expected = {
            "22:32: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            "23:43: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            "26:62: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            "27:20: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            "28:9: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            "40:31: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
            // "45:20: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_UNMODIFIABLE_LIST),
        };
        verifyWithInlineConfigParser(getPath("InputUseModernAPIForCollectors.java"), expected);
    }

    // @Test
    // public void stream() throws Exception {
    //     final String[] expected = {
    //             "22:17: " + getCheckMessage(MSG_OUTDATED_API_USAGE, TO_LIST),
    //     };
    //     verifyWithInlineConfigParser(getPath("InputUseModernAPIForStream.java"), expected);
    // }
    //
    // @Test
    // public void url() throws Exception {
    //     final String[] expected = {
    //             "16:9: " + getCheckMessage(MSG_OUTDATED_API_USAGE, NEW_URL_STRING),
    //     };
    //     verifyWithInlineConfigParser(getPath("InputUseModernAPIForURL.java"), expected);
    // }
    //
    // @Test
    // public void locale() throws Exception {
    //     final String[] expected = {
    //             "14:9: " + getCheckMessage(MSG_OUTDATED_API_USAGE, NEW_LOCALE_STRING_STRING),
    //             "15:9: " + getCheckMessage(MSG_OUTDATED_API_USAGE, NEW_LOCALE_STRING),
    //     };
    //     verifyWithInlineConfigParser(getPath("InputUseModernAPIForLocale.java"), expected);
    // }
}
