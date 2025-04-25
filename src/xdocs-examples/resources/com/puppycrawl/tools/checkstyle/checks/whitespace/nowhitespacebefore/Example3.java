/*xml
<module name="Checker">
  <module name="NoWhitespaceBefore"/>
</module>


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.nowhitespacebefore;

import com.google.common.collect.Lists;

// xdoc section -- start
class Example3 {
  void example() {
    Lists.charactersOf("foo").listIterator()
         .forEachRemaining(System.out::print);
    // violation above ''.' is preceded with whitespace'
    Lists.charactersOf("foo").listIterator().forEachRemaining(System.out ::print);
    // violation above ''::' is preceded with whitespace'
    Lists.charactersOf("foo").listIterator().forEachRemaining(System.out::print);
  }
}
// xdoc section -- end
