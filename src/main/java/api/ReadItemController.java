package api;

import domain.Item;
import query.QueryBus;
import query.impl.GetItemQuery;

import java.util.UUID;

public class ReadItemController {

    private final QueryBus queryBus;

    public ReadItemController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    public Item getItem(UUID id){
        return queryBus.execute(new GetItemQuery(id));
    }
}
