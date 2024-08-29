package Pack;

public class ConcreteBidder implements Bidder {

    private String name;

    public ConcreteBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String itemName, String event) {
        System.out.println("Notification to " + name + ": " + event + " for item: " + itemName);
    }

    @Override
    public String getName() {
        return name;
    }
}