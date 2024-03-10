package hello.itemservice.domain.item;

import lombok.Data;

//@Data -> 롬복에 있는 애(@Getter, @Setter 만들어주고, @RequireArgsContstructer @ToString등 여러 메서드 만들어줌
//근데 최대한 안쓰는 걸 생각하자 => DTO에는 써도 괜찮음
@Data
public class Item {
    private Long id;
    private String itemName;
    //int는 null이 들어갈 수 없음.. price가 0인게 이상하잖아 -> null로 지정해줘야지
    private Integer price;
    private Integer quantity;

    public Item(){
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
