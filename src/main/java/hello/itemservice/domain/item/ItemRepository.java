package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); //static
    //실무에서는 ConcurrentHashMap을 사용해야한다
    private static long sequence = 0L; //static
    //실무에선 long 쓰면 안돼

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    //원래는 그냥 UpdateParamDTO 객체 하나 만들어서 받아오는게 나음
    public void update(Long itemId, Item updateParam) {
       Item findItem = findById(itemId);
       findItem.setItemName(updateParam.getItemName());
       findItem.setPrice(updateParam.getPrice());
       findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
