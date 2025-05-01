/*
Whitespace


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.whitespace;

/**
 * Class for testing whitespace issues.
 * violation missing author tag
 **/
class InputWhitespaceDefault
{
    public void test() {
        // Valid cases
        " ".equals("");
        "".equals(" ");
        "".equals("");

        // Violations
        "".equals("");
        "".equals(""  + ""); // violation contains invalid whitespace.
        "".equals("" +  ""); // violation contains invalid whitespace.
         System.out.println(""); // violation contains invalid whitespace.
        System .out.println(""); // violation contains invalid whitespace.
        System. out.println(""); // violation contains invalid whitespace.
        System.out .println(""); // violation contains invalid whitespace.
        System.out. println(""); // violation contains invalid whitespace.
        System.out. println(""); // violation contains invalid whitespace.
        System.out.println (""); // violation contains invalid whitespace.
        "" .equals(""); // violation contains invalid whitespace.
        "". equals(""); // violation contains invalid whitespace.
        "".equals (""); // violation contains invalid whitespace.
        "".equals( ""); // violation contains invalid whitespace.
        "".equals("" ); // violation contains invalid whitespace.
        "".equals("") ; // violation contains invalid whitespace.
    }

    /** Test variable assignment violations */
    public void testSpaceViolationVarAssignment() {
        // Valid
        boolean eq1 = " ".equals("");
        boolean eq2 = "".equals("");

        // Violations
        eq2 = "".equals(""); // violation contains invalid whitespace.
        eq2  = "".equals(""); // violation contains invalid whitespace.
        eq2 =  "".equals(""); // violation contains invalid whitespace.
    }

    /** Test variable declaration violations */
    public void testSpaceViolationVarDeclaration() {
        // Valid
        boolean e = "".equals("");
        boolean e3 = "".equals("");
        e3 = "".equals("");

        // Violations
        boolean e4 = "".equals(""); // violation contains invalid whitespace.
        boolean e1  = "".equals(""); // violation contains invalid whitespace.
        boolean  e2 = "".equals(""); // violation contains invalid whitespace.
        e3 = "".equals(""); // violation contains invalid whitespace.
        e3  = "".equals(""); // violation contains invalid whitespace.
        e3 =  "".equals(""); // violation contains invalid whitespace.
    }

    /** Test array access violations */
    public void testArrayAccess() {
        int[] arr = new int[10];

        // Valid
        int a = arr[0];

        // Violations
        int x = arr [0]; // violation contains invalid whitespace.
        int y = arr[ 0]; // violation contains invalid whitespace.
        int z = arr[0]; // violation contains invalid whitespace.
    }

    /** Test generics violations */
    public void testGenerics() {
        java.util.List<String> list = new java.util.ArrayList<>();

        // Valid
        list.add("test");

        // Violations
        list .add("test"); // violation contains invalid whitespace.
        list. add("test"); // violation contains invalid whitespace.
    }

    /** Test lambda violations */
    public void testLambda() {
        // Valid
        Runnable r = () -> System.out.println();

        // Violation
        Runnable r2 = () -> System.out .println(); // violation contains invalid whitespace.
    }

    /** Test method reference violations */
    public void testMethodReference() {
        // Valid
        java.util.function.Function<String, String> f1 = String::valueOf;

        // Violation
        java.util.function.Function<String, String> f2 = String ::valueOf; // violation contains invalid whitespace.
    }

    /** Test nested calls violations */
    public void testNestedCalls() {
        String s = "hello";

        // Valid
        s.substring(1).trim();
        s.substring(1).trim();

        // Violations
        s.substring(1). trim(); // violation contains invalid whitespace.
        s.substring(1 ).trim(); // violation contains invalid whitespace.
    }

    /** Test multiple dots violations */
    public void testMultipleDots() {
        String s = "hello";

        // Valid
        s.substring(1).substring(1).substring(1);

        // Violations
        s.substring(1).substring(1). substring(1); // violation contains invalid whitespace.
        s.substring(1) .substring(1).substring(1); // violation contains invalid whitespace.
    }

    /** Test with other operators */
    public void testWithOtherOperators() {
        // Valid
        String s1 = "a" + "b".toString();
        int x = 1 + 2 * 3;

        // Violation
        String s2 = "a" + "b". toString(); // violation contains invalid whitespace.
    }

    /** Test in control structures */
    public void testInControlStructures() {
        // Valid
        if ("test".equals("test")) {
            System.out.println();
        }

        // Violations
        if ("test". equals("test")) { // violation contains invalid whitespace.
            System.out.println();
        }

        while (true) {
            break ;
        }
    }

    /** Test in try-catch */
    public void testInTryCatch() {
        // Valid
        try {
            // do something
        } catch (Exception e) {
            // handle
        }

        // Violation
        try {
            // do something
        } catch (Exception e ) { // violation contains invalid whitespace.
            // handle
        }
    }

    /** Test in annotations */
    public void testInAnnotations() {
        // Valid
        @SuppressWarnings("unchecked")
        Object o1 = new Object();

        // Violation
        @SuppressWarnings ("unchecked") // violation contains invalid whitespace.
        Object o2 = new Object();
    }

    /** Test in type cast */
    public void testInTypeCast() {
        Object o = "test";

        // Valid
        String s1 = (String) o;

        // Violation
        String s2 = (String ) o; // violation contains invalid whitespace.
    }

    /** Test in switch */
    public void testInSwitch() {
        // Valid
        switch (1) {
            case 1:
                break;
        }

        // Violation
        switch (1 ) { // violation contains invalid whitespace.
            case 1:
                break;
        }
    }

    /** Test in synchronized */
    public void testInSynchronized() {
        // Valid
        synchronized (this) {
            // do something
        }

        // Violation
        synchronized (this ) { // violation contains invalid whitespace.
            // do something
        }
    }

    /** Test in assert */
    public void testInAssert() {
        // Valid
        assert true : "message";

        // Violation
        assert true : "message" ; // violation contains invalid whitespace.
    }

    /** Test in return */
    public void testInReturn() {
        // Valid (no return value)
        return;
    }

    public void testInReturn2() {
        // Violation
        return ; // violation contains invalid whitespace.
    }

    /** Test in throw */
    public void testInThrow() throws Exception {
        // Valid
        throw new Exception();
    }

    public void testInThrow2() throws Exception {
        // Violation
        throw new Exception() ; // violation contains invalid whitespace.
    }

    /** Test in array initializer */
    public void testInArrayInitializer() {
        // Valid
        int[] arr1 = new int[] {1, 2, 3};

        // Violation
        int[] arr2 = new int[] {1, 2, 3 } ; // violation contains invalid whitespace.
    }
}
