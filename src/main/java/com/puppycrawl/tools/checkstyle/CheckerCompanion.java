package com.puppycrawl.tools.checkstyle;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.puppycrawl.tools.checkstyle.api.ExternalResourceHolder;
import com.puppycrawl.tools.checkstyle.api.FileSetCheck;
import com.puppycrawl.tools.checkstyle.api.FilterSet;

class CheckerCompanion {

    /**
     * Extracts localized messages from properties files.
     *
     * @param messageKey  the key pointing to localized message in respective properties file.
     * @param sourceClass the Checker class that is the source of the message, used to determine
     *                    the appropriate resource bundle.
     * @param args        the arguments of message in respective properties file.
     * @return a string containing extracted localized message
     */
    static String getLocalizedMessage(String messageKey,
                                      Class<? extends Checker> sourceClass,
                                      Object... args) {
        return new LocalizedMessage(
            Definitions.CHECKSTYLE_BUNDLE,
            sourceClass,
            messageKey,
            args
        ).getMessage();
    }

    /**
     * Returns a set of external configuration resource locations which are used by all file set
     * checks and filters.
     *
     * @param fileSetChecks the list of file set checks to process for external resources
     * @param filters       the filter set to process for external resources
     * @return a set of external configuration resource locations which are used by all file set
     * checks and filters.
     */
    static Set<String> getExternalResourceLocations(List<FileSetCheck> fileSetChecks,
                                                    FilterSet filters) {
        return Stream.concat(fileSetChecks.stream(), filters.getFilters().stream())
            .filter(ExternalResourceHolder.class::isInstance)
            .flatMap(resource
                -> ((ExternalResourceHolder) resource).getExternalResourceLocations().stream())
            .collect(Collectors.toUnmodifiableSet());
    }
}
