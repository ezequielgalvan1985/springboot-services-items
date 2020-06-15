package udemy.microservices.springbootserviceitems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.microservices.springbootserviceitems.model.Item;
import udemy.microservices.springbootserviceitems.model.service.ItemService;
import udemy.microservices.springbootserviceitems.model.service.ItemServiceImpl;

import java.util.List;

@RequestMapping("api/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> listar(){
        return itemService.findAll();
    }

    @GetMapping("/id/{id}/cantidad/{cantidad}/")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.findById(id, cantidad);
    }

}
