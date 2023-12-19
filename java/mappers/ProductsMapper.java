package mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import service.Product;

public class ProductsMapper implements RowMapper<Product>{
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("Name"));
        product.setCost(rs.getInt("Cost"));
        return product;
    }
}
