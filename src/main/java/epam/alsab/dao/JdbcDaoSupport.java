package epam.alsab.dao;

import epam.alsab.service.DvdConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDaoSupport {

    public Connection getConnection() throws SQLException {
        return new DvdConnection().getConnection();
    }

    public void update(String sql, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T select(String sql, Mapper<T> mapper, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            T t = mapper.rowmap(rs);
            rs.close();
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> selectList(String sql, Mapper<T> mapper, Object... params) {

        List<T> tList = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tList.add(mapper.rowmap(rs));
            }
            rs.close();
            return tList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public interface Mapper<T> {
        T rowmap(ResultSet rs) throws SQLException;
    }
}
