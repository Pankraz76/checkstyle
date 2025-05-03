/*
AvoidOutdatedUsage

*/
package com.puppycrawl.tools.checkstyle.checks.coding.avoidoutdatedusage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class InputAvoidOutdatedUsageForURL {

    static String FOO = "foo";

    private static void URL() throws MalformedURLException {
        new URL(FOO); // violation, Outdated api usage 'new URL(String)'
        URI.create(FOO).toURL(); // ok, as modern
        // TODO Usage of API documented as @since 20+
        // URL.of(FOO);
    }

}
