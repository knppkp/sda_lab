package Task2;

public class Mediator {

    private AmericanSeller americanSeller;
    private SwedishBuyer swedishBuyer;
    private FrenchBuyer frenchBuyer;
    private DollarConverter dollarConverter;

    // Register participants
    public void registerAmericanSeller(AmericanSeller seller) {
        this.americanSeller = seller;
    }

    public void registerSwedishBuyer(SwedishBuyer buyer) {
        this.swedishBuyer = buyer;
    }

    public void registerFrenchBuyer(FrenchBuyer buyer) {
        this.frenchBuyer = buyer;
    }

    public void registerDollarConverter(DollarConverter converter) {
        this.dollarConverter = converter;
    }

    // Handle bids from buyers
    public boolean placeBid(float bid, String unitOfCurrency) {
        // Convert buyer’s bid into dollars
        float bidInDollars = dollarConverter.convertCurrencyToDollars(bid, unitOfCurrency);
        // Ask seller if the bid is accepted
        return americanSeller.isBidAccepted(bidInDollars);
    }
}
