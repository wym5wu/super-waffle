package soft.mapper;

import soft.bean.Admin;
import soft.bean.Menu;

import java.util.List;

public interface MenuMapper {
    public List<Menu> findMenus();
    public List<Admin> findeAlluser();
    public List<Menu> findMenu();
    public List<Admin> findeAlluser1();
}
