package com.example.orderservice;

import service.Order;
import service.Product;

import java.util.List;

public interface OrderService {

    public void addOrder();
    public Order getOrder(int id);
    public List<Order> getOrders();
    public void deleteOrder(int id);
    public void correctOrder();
    public void createProdTable();
    public void createOrderTable();
    public void addProduct();
    public Product getProduct(int id);
    public List<Product> getProducts();
    public void deleteProduct(int id);
    public void correctProduct();


}
