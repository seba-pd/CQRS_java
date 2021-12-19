package query.impl;

import query.ItemReadRepository;
import query.Query;
import query.QueryHandler;
import domain.Item;

import java.io.FileNotFoundException;

public class GetItemQueryHandler implements QueryHandler {

    private ItemReadRepository itemReadRepository;

    public GetItemQueryHandler(ItemReadRepository itemReadRepository) {
        this.itemReadRepository = itemReadRepository;
    }

    @Override
    public Item handle(Query query) {
        GetItemQuery handledQuery = (GetItemQuery) query;
        Item item = itemReadRepository.getItem(handledQuery.getId());
        if(item.getName().isEmpty()) try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return item;
    }
}
