package TBot;

import java.util.Map;
import java.util.HashMap;

public class MarsStorage implements Storage {
    private Map<String, Integer> inventory = new HashMap<>();

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    @Override
    public void addResource(String name, int amount){
        if (amount <= 0){
            System.out.println("Invalid amount");
            return;
        }
        inventory.put(name, inventory.getOrDefault(name, 0) + amount);
        System.out.println("Added resource " + name + "-" + amount + "cnt " + " to mars storage");
    }

    @Override
    public void removeResource(String name, int amount) throws InsufficientResourcesException {
        int currentAmount = inventory.getOrDefault(name, 0);
        if (currentAmount < amount){
            throw new InsufficientResourcesException("❌ Ошибка: Недостаточно " + name +
                    ". В наличии: " + currentAmount + ", нужно: " + amount);
        }
        inventory.put(name, currentAmount - amount);
        System.out.println("✅ Успешно списано " + amount + " ед. ресурса " + name);
    }

    @Override
    public void printInventory() {
        System.out.println("\n--- 🛰️ СКЛАД МАРСА ---");System.out.println("\n--- 🛰️ СКЛАД МАРСА ---");
        if (inventory.isEmpty()){
            System.out.println("Склад пуст :(");
        }
        else  {
            for (var entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }
        System.out.println("--------------\n");
    }
}
