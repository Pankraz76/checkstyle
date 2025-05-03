/*
UseModernAPI

*/
package com.puppycrawl.tools.checkstyle.checks.coding.usemodernapi;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class InputUseModernAPIForStream {

    static String FOO = "foo";

    /**
     * 'List.of().stream()' can be replaced with 'Stream.of()'
     * Can be replaced with 'java.util.ArrayList' constructor
     */
    private static void listOfStreamToList() {
        List.of(new Locale(FOO, FOO))
                // 'List.of().stream()' can be replaced with 'Stream.of()'
                .stream() // violation, Outdated api usage 'List.of().stream()'
                // Can be replaced with 'java.util.ArrayList' constructor
                .collect(Collectors.toList()); // violation, Outdated api usage 'Collectors.toList()'
    }
}
