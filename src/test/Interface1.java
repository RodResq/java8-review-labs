package test;

@FunctionalInterface
public interface Interface1 {
    void printName(String value);
    default void testDefaultMethod(String value) {
        System.out.println("Default print and class " + value);
    }

    static void testingStatic() {
        System.out.println("testing statis super method");
    }
}


