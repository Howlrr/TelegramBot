package TBot;

public interface Storage {
    void addResource(String name, int amount);

    void removeResource(String name, int amount) throws InsufficientResourcesException;

    void printInventory();
}
