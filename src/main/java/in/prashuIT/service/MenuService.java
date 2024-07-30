package in.prashuIT.service;

import java.util.List;

import in.prashuIT.binding.Menu;

public interface MenuService {
	
	public String upsert( Menu menu);
	
	public Menu getById( Integer id);
	
	public List<Menu> getAllMenus();
	
   public String deleteById(Integer id);




}
