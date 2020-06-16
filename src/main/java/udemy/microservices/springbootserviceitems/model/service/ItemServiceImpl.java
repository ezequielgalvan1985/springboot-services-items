package udemy.microservices.springbootserviceitems.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import udemy.microservices.springbootserviceitems.model.Item;
import udemy.microservices.springbootserviceitems.model.Producto;
import udemy.microservices.springbootserviceitems.model.service.ItemService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/api/productos/", Producto[].class));

        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id",id.toString());

        Producto p = clienteRest.getForObject("http://servicio-productos/api/productos/{id}/", Producto.class, pathVariables);
        return new Item(p, cantidad);
    }
}
