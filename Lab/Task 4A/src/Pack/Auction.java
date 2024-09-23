package Pack;


import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionEventManager {

    private List<Bidder> bidders;
    private String itemName;
    private boolean isBiddingActive;

    public Auction(String itemName) {
        this.itemName = itemName;
        this.bidders = new ArrayList<>();
        this.isBiddingActive = false;
    }

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
        System.out.println(bidder.getName() + " has registered for item: " + itemName);
    }

    @Override
    public void removeBidder(Bidder bidder) {
        bidders.remove(bidder);
        System.out.println(bidder.getName() + " has unsubscribed from item: " + itemName);
    }

    @Override
    public void notifyBidders(String event) {
        for (Bidder bidder : bidders) {
            bidder.update(itemName, event);
        }
    }

    public void startBidding() {
        isBiddingActive = true;
        notifyBidders("Bidding has started");
    }

    public void endBidding() {
        isBiddingActive = false;
        notifyBidders("Bidding has ended");
    }

    public void itemAvailable() {
        notifyBidders("Item is now available");
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isBiddingActive() {
        return isBiddingActive;
    }
}
