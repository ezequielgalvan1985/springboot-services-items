package udemy.microservices.springbootserviceitems.model.service;

import udemy.microservices.springbootserviceitems.model.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);

}
