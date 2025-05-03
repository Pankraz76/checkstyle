/*
UseModernAPI

*/
package com.puppycrawl.tools.checkstyle.checks.coding.usemodernapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InputUseModernAPIForCollectors {

    static String FOO = "foo";

    private static void Collectors() {
        // TODO Usage of API documented as @since 16+
        // Stream.of(FOO).toList(); // ok, as modern
        Stream.of(FOO).collect(toList()); // violation, Outdated api usage 'Collectors.toList()'
        Stream.of(FOO).collect(Collectors.toList()); // violation, Outdated api usage 'Collectors.toList()'
        // Can be replaced with 'java.util.ArrayList' constructor
        new ArrayList<>(List.of(FOO)); // ok, as modern
        Collector<Object, ?, List<Object>> list = Collectors.toList(); // violation, Outdated api usage 'Collectors.toList()'
        Collectors.toList(); // violation, Outdated api usage 'Collectors.toList()'
        toList(); // violation, Outdated api usage 'Collectors.toList()'
        // TODO Usage of API documented as @since 16+
        // List.of(FOO).stream().toList(); // ok, as modern
        // Stream.of(FOO).toList(); // ok, as modern
        // Test other Collector methods
        Collectors.toCollection(ArrayList::new); // ok, modern API
    }

    static class Foo {
        private static void toList() { // ok, as custom
        }
    }
}