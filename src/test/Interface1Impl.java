package test;

public class Interface1Impl implements Interface1 {

    @Override
    public void printName(String value) {

    }

    public static void main(String[] args) {
        Interface1Impl impl = new Interface1Impl();
        impl.testDefaultMethod("Rodrigo Resque");
        Interface1.testingStatic();
    }

}
