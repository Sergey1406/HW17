package mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import service.Order;


public class OrdersMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setName(rs.getString("Name"));
        order.setDate(rs.getDate("Date"));
        order.setProdId(rs.getInt("ProdId"));
        return order;
    }
}
