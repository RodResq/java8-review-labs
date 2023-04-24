package test;

@FunctionalInterface
public interface OperationExample<Integer> {
    int square(int value);

    static  String getOperationNature() {
        return "This is operation interface";
    }
}
