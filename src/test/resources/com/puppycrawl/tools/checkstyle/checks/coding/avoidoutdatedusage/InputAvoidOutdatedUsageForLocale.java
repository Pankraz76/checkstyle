/*
AvoidOutdatedUsage

*/
package com.puppycrawl.tools.checkstyle.checks.coding.avoidoutdatedusage;

import java.util.Locale;

public class InputAvoidOutdatedUsageForLocale {

    static String FOO = "foo";

    private static void Locale()  {
        new Locale(FOO, FOO); // violation, Outdated api usage 'new Locale(String, String)'
        new Locale(FOO); // violation, Outdated api usage 'new Locale(String)'
        // TODO Usage of API documented as @since 19+
        // Locale.of(FOO, FOO); // ok, as modern
        // Locale.of(FOO); // ok, as modern
    }
}
