import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IObjectDAO {
    public void save(Object obj)  throws SQLException;
    public void update(Object obj)  throws SQLException;
    public void delete(Object obj)  throws SQLException;
    public List getObjFromTable(String nameObj) throws SQLException;
    public List getObjFromTable(String nameObj,String nameValue, List<Object> ids) throws SQLException;
    public List getObjFromTable(String nameObj, String queryString) throws SQLException;
    public <T>List getObjFromTable() throws SQLException;
}
