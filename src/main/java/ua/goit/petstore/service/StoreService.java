package ua.goit.petstore.service;

import ua.goit.petstore.model.Order;
import ua.goit.petstore.repository.OrderRepository;

import java.util.Map;

public class StoreService extends BaseService<Order, Long> {

    private final OrderRepository repository = new OrderRepository(Order.class);

    public Map<String, Integer> getByStatus (){
        return repository.getOrdersByStatus();
    }
    //
    public Order save (Order order){
        return repository.create(order);
    }

    public Order delete(Long id){
        return repository.deleteById(id);
    }

    public Order findById (Long id) {
        return repository.getOne(id);
    }
}
