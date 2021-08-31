package digitalinnovation.one.experts.shoppingcart.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("item")
public class Item {

    private Integer productId;
    private Integer amount;
}
