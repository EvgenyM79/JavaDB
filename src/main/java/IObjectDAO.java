import java.sql.SQLException;
import java.util.List;

public interface IObjectDAO {
    public void save(Object obj)  throws SQLException;
    public void update(Object obj)  throws SQLException;
    public void delete(Object obj)  throws SQLException;
    public List getObjFromTable(String nameObj) throws SQLException;
    //public List getObjFromTable(String nameObj,String nameValue, List<Object> ids) throws SQLException;
    public List<EducateBuilding> getObjFromTable(String nameObj, String val) throws SQLException;
    public <T>List getObjFromTable() throws SQLException;
    public Parents findByIdParent(int id);
    public Children findByIdChild(int id);
    public EducateBuilding findByIdEducation(int id);
}
