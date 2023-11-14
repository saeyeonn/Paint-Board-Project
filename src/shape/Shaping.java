package shape;

public interface Shaping {
    default Shape shape() {
        return null;
    }
}
