package udemy.microservices.springbootserviceitems.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import udemy.microservices.springbootserviceitems.clientes.ProductoClienteRest;
import udemy.microservices.springbootserviceitems.model.Item;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductoClienteRest clienteFeign;

    @Override
    public List<Item> findAll() {
        return clienteFeign.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clienteFeign.view(id),cantidad);
    }
}
