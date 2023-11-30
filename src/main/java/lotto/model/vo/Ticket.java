package lotto.model.vo;

public class Ticket {
    
    private final Integer quantity;

    public Ticket(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
