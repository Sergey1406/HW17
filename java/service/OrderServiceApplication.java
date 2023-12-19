package service;

import com.example.orderservice.OrderService;
import jakarta.annotation.PostConstruct;
import mappers.OrdersMapper;
import mappers.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class OrderServiceApplication implements OrderService {


    JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderServiceApplication(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createProdTable(){
        jdbcTemplate.execute("CREATE TABLE PRODUCTS (id INT, name VARCHAR, cost INT)");
    }

    @Override
    public void createOrderTable(){
        jdbcTemplate.execute("CREATE TABLE ORDERS (id INT, Name VARCHAR, Date DATE,  prodId INT)");
    }

    @Override
    public void deleteOrder(int id){
        String SQL = "DELETE FROM Orders WHERE id=?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    @PostConstruct
    public List<Order> getOrders(){
        String SQL = "select * from Orders";
        List <Order> orders = jdbcTemplate.query(SQL, new OrdersMapper());
        System.out.println(orders.get(1).getName());
        return orders;
    }

    @Override
    public Order getOrder(int id){
        StringBuffer s = new StringBuffer("SELECT* FROM Orders WHERE id=").append(id);
        String SQL = new String(s);
        Order order = jdbcTemplate.queryForObject(SQL, new OrdersMapper());
        System.out.println(order.getName());
        return order;
    }

    @Override
    public void addOrder(){
        String sd = "INSERT INTO Orders(id, Name, Date, ProdId) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sd, 3, "Mouse", new java.sql.Date(System.currentTimeMillis()), 5);
    }


    @Override
    public void correctOrder(){
        int id = 3;
        String SQL = "UPDATE ORDERS SET Name = ? WHERE id = ?";
        jdbcTemplate.update(SQL, "SSS", 3);
    }

    @Override
    public void addProduct(){
        String SQL = "INSERT INTO Products(id, Name, cost) VALUES (?, ?, ?)";
        jdbcTemplate.update(SQL, 6, "Phone", 8);
    }

    @Override
    public Product getProduct(int id){
        StringBuffer s = new StringBuffer("SELECT* FROM Products WHERE id=").append(id);
        String SQL = new String(s);
        Product product = jdbcTemplate.queryForObject(SQL, new ProductsMapper());
        return product;
    }

    @Override
    @PostConstruct
    public List<Product> getProducts(){
        String SQL = "select * from Products";
        List <Product> products = jdbcTemplate.query(SQL, new ProductsMapper());
        System.out.println(products.get(1).getName());
        return products;
    }

    @Override
    public void deleteProduct(int id){
        String SQL = "DELETE FROM Products WHERE id=?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void correctProduct(){
        String SQL = "UPDATE Products SET Name = ? WHERE id = ?";
        jdbcTemplate.update(SQL, "Laptop", 6);
    }



    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);

    }
    }



