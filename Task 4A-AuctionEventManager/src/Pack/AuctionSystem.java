package Pack;

public class AuctionSystem {

    public static void main(String[] args) {
        // Create an auction for an item
        Auction auction = new Auction("Vintage Painting");

        // Create bidders
        Bidder bidder1 = new ConcreteBidder("Alice");
        Bidder bidder2 = new ConcreteBidder("Bob");
        Bidder bidder3 = new ConcreteBidder("Charlie");

        // Register bidders to the auction
        auction.registerBidder(bidder1);
        auction.registerBidder(bidder2);

        // Notify item availability
        auction.itemAvailable();

        // Start bidding
        auction.startBidding();

        // Bob decides to unsubscribe
        auction.removeBidder(bidder2);

        // Charlie subscribes
        auction.registerBidder(bidder3);

        // End bidding
        auction.endBidding();
    }
}