package udemy.microservices.springbootserviceitems.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import udemy.microservices.springbootserviceitems.model.Producto;

import java.util.List;

@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {

    @GetMapping("api/productos/")
    public List<Producto> list();

    @GetMapping("api/productos/{id}/")
    public Producto view(@PathVariable Long id);

}
