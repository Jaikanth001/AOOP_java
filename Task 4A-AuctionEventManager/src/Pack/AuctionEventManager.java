package Pack;

import java.util.List;

public interface AuctionEventManager {
    void registerBidder(Bidder bidder);
    void removeBidder(Bidder bidder);
    void notifyBidders(String event);
}