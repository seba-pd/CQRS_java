package query;

import domain.Item;

import java.util.UUID;

public interface ItemReadRepository  {

    Item getItem (UUID id);
}
