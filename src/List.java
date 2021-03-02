public interface List <T>{
    void prependNode(T value);
    void appendNode(T value);
    void removeNode(T value);
    void traverseForward();
    void traverseBackward();
}
