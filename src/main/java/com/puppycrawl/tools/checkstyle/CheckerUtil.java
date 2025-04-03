/// ////////////////////////////////////////////////////////////////////////////////////////////
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
/// ////////////////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle;

import java.util.List;

import com.puppycrawl.tools.checkstyle.api.AuditEvent;
import com.puppycrawl.tools.checkstyle.api.AuditListener;
import com.puppycrawl.tools.checkstyle.api.FilterSet;

/**
 * Utility class for {@link Checker} that handles common operations and helper methods.
 * <p>
 * This class was created to reduce code complexity in {@link Checker}, which was approaching
 * its method count limit (34 out of 35 allowed methods). It serves as a companion to Checker,
 * containing implementation details to keep the main Checker class focused on its core
 * responsibilities.
 * </p>
 * <p>
 * All methods in this class are static and the class cannot be instantiated.
 * </p>
 *
 * @see Checker
 */
final class CheckerUtil {

    /**
     * Private constructor to prevent instantiation.
     */
    private CheckerUtil() {
    }

    /**
     * Extracts localized messages from properties files.
     *
     * @param messageKey the key pointing to localized message in respective properties file
     * @param aClass the Checker class to use for localization context
     * @param args the arguments to be substituted in the localized message
     * @return a string containing the extracted localized message
     */
    static String getLocalizedMessage(String messageKey,
                                      Class<? extends Checker> aClass,
                                      Object... args) {
        return new LocalizedMessage(Definitions.CHECKSTYLE_BUNDLE, aClass, messageKey, args)
            .getMessage();
    }

    /**
     * Notifies all listeners about the audit start event.
     *
     * @param listeners list of audit listeners to notify
     * @param checker the Checker instance that is starting the audit
     */
    static void fireAuditStarted(List<AuditListener> listeners, Checker checker) {
        for (final AuditListener listener : listeners) {
            listener.auditStarted(new AuditEvent(checker));
        }
    }

    /**
     * Notifies all listeners about the audit finish event.
     *
     * @param listeners list of audit listeners to notify
     * @param checker the Checker instance that is finishing the audit
     */
    static void fireAuditFinished(List<AuditListener> listeners, Checker checker) {
        for (final AuditListener listener : listeners) {
            listener.auditFinished(new AuditEvent(checker));
        }
    }

    /**
     * Processes an audit event through filters and notifies listeners if accepted.
     * <p>
     * The method checks if the event passes through the given filters. If it does,
     * the event is forwarded to all listeners and the violation flag is set to true.
     * </p>
     *
     * @param event the audit event to process
     * @param hasNonFilteredViolations current state of the violation flag
     * @param filters the set of filters to check the event against
     * @param listeners the list of listeners to notify if event passes filters
     * @return updated violation flag (true if event passed filters, original value otherwise)
     */
    static boolean addErrorToListeners(AuditEvent event, boolean hasNonFilteredViolations,
                                       FilterSet filters, List<AuditListener> listeners) {
        if (filters.accept(event)) {
            hasNonFilteredViolations = true;
            for (final AuditListener listener : listeners) {
                listener.addError(event);
            }
        }
        return hasNonFilteredViolations;
    }
}
