package controller;

import model.Fruit;
import model.OrderItem;
import valation.validation;

import java.lang.classfile.CustomAttribute;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FruitManagement {
    public List<Fruit> fruitList =new ArrayList<>();
    public Hashtable<String,List<OrderItem>> orderMap =new Hashtable<>();
    public List<Fruit> initData(){
        fruitList.add(new Fruit("fr1","banana",120,12,"usa"));
        fruitList.add(new Fruit("fr2","apple",120,12,"usa"));
        fruitList.add(new Fruit("fr3","pine apple",120,12,"usa"));
        fruitList.add(new Fruit("fr4","orange",120,12,"usa"));
        fruitList.add(new Fruit("fr5","duriance",120,12,"usa"));
        return fruitList;
    }
    //add fruit
    public void createFruit() {
        while(true) {
            Fruit duplicate = null;
            String fruitId = validation.getString("Enter Fruit ID: ");
            if (fruitId.contains(" ")) {
                System.out.println("Fruit ID cannot contain spaces.");
                continue;
            }
            String fruitName = validation.getString("Enter Fruit Name: ");
            boolean conflict = false;
            for (Fruit fruit : fruitList) {
                if (fruit.getFruitId().equals(fruitId)) {
                    if (fruit.getFruitName().equals(fruitName)) {
                        duplicate = fruit;
                    } else {
                        conflict = true;
                    }
                    break;
                }
            }
            if(conflict) {
                System.out.println("Fruit ID: " + fruitId + " already exists");
                continue;
            }
            double price = validation.getDouble("Enter price: ", 1, Integer.MAX_VALUE);
            int quantity = validation.getInt("Enter quantity ", 1, Integer.MAX_VALUE);
            String origin = validation.getString("Enter Origin: ");
            //if int-put exiting fruit add will become update
            if(duplicate != null) {
                boolean opts = validation.getYesNo("Do you want to update Fruit ID: " + "(Y/n)" + fruitId + " and Fruit Name: " + fruitName);
                if (opts) {
                    duplicate.setPrice(price);
                    duplicate.setQuantity(duplicate.getQuantity() + quantity);
                    duplicate.setOrigin(origin);
                    System.out.println("Fruit Updated");
                }else{
                continue;
                }
            }else {
                //add fruit
                fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
                System.out.println("Fruit Added");
            }
            boolean opts = validation.getYesNo("Do you want to continue?"+"(Y/N)");
            if(!opts) {
                return;
            }
        }
    }
    public void viewOrder() {
       if(orderMap.isEmpty()) {
           System.out.println("No Order Found");
       }
        System.out.println("Number customer: "+orderMap.size());
       //duyet theo danh sach khac hang va tin ra
        for(String customerName : orderMap.keySet()) {
            System.out.println("Customer: "+customerName);
            List<OrderItem> item = orderMap.get(customerName);
            System.out.printf("%-10s|%-10s|%-10s|%-10s%n",
            "Fruit Name",
            "Quantity",
            "Price",
            "Total Price"
            );
            double total = 0;
            for(OrderItem orderItem : item) {
                System.out.println(orderItem);
                total += orderItem.getAmount();
            }
            System.out.println("Total: "+total);
        }
    }
    public void shopping() {
        System.out.println("===Fruit Shopping===");
        if(fruitList.isEmpty()) {
            createFruit();
        }
        boolean allOuted = false;
        for(Fruit fruit : fruitList) {
            if(fruit.getQuantity() > 0) {
                allOuted = true;
                break;
            }
        }
        if(!allOuted) {
            System.out.println("All items are sold out. we will update soon.");
            return;
        }
        List<OrderItem> orderItems = new ArrayList<>();
        displayFruit(fruitList);
        while(true) {
            //select fruit to buy
            int index = validation.getInt("Select Fruit to buy", 1, fruitList.size()) - 1;
            Fruit fruit = fruitList.get(index);
            System.out.println("You selected " + fruit.getFruitName());
            if (fruit.getQuantity() <= 0) {
                System.out.println("Sold out !! ");
                continue;
            }
            //input quantity
            int quantity = validation.getInt("Enter quantity want to buy:", 1, fruit.getQuantity());
            orderItems.add(new OrderItem(fruit.getFruitName(), quantity, fruit.getPrice()));
            fruit.setQuantity(fruit.getQuantity() - quantity);
            System.out.println("Your order has been built");

            boolean opts = validation.getYesNo("Do you want to continue?" + "(Y/N)");
            if (!opts) {
                String customerName = validation.getString("Enter customer name:");

                    //map customer vao bill
                    orderMap.put(customerName,orderItems);
                return;
            }
        }
   }
    public void displayFruit(List<Fruit> fruitList ) {
        if(fruitList.isEmpty()) {
            System.out.println("Fruit List is empty");
            return;
        }
        System.out.printf("%5s|%10s|%10s|%10s|%10s%n",
                "No",
                "Fruit Name",
                "Quantity",
                "Price",
                "Origin"
        );
        int index = 1;
        // fruit co so luong bang khong thi se hien thi sold out
        String quantity;
        for(Fruit fruit : fruitList) {
            if(fruit.getQuantity() <= 0) {
                quantity = "Sold out";
            }
            else {
                quantity = String.valueOf(fruit.getQuantity());
            }
            System.out.printf("%5s|%10s|%10s|%10.2f|%10s%n",
                    index,
                    fruit.getFruitName(),
                    quantity,
                    fruit.getPrice(),
                    fruit.getOrigin()
            );
            index++;
        }
    }
}
