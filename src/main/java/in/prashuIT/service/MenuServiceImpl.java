package in.prashuIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.prashuIT.binding.Menu;
import in.prashuIT.repo.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public String upsert(Menu menu) {
		menuRepository.save(menu);
		return "Record save";
	}

	@Override
	public Menu getById(Integer id) {
		Optional<Menu> findById= menuRepository.findById(id);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}

	@Override
	public String deleteById(Integer id) {
	  if(menuRepository.existsById(id)) {
			menuRepository.deleteById(id);
			return "Delete Sucess";
		}else {
			return "No Record found";
		}
	}
}
