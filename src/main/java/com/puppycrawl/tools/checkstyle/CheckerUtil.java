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

class CheckerUtil {

    /**
     * Extracts localized messages from properties files.
     *
     * @param messageKey the key pointing to localized message in respective properties file.
     * @param aClass
     * @param args       the arguments of message in respective properties file.
     * @return a string containing extracted localized message
     */
    static String getLocalizedMessage(String messageKey,
                                      Class<? extends Checker> aClass,
                                      Object... args) {
        return new LocalizedMessage(Definitions.CHECKSTYLE_BUNDLE, aClass, messageKey, args)
            .getMessage();
    }

}
