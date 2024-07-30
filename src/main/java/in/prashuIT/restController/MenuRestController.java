package in.prashuIT.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.prashuIT.binding.Menu;
import in.prashuIT.service.MenuService;

@RestController
public class MenuRestController {

	@Autowired
	private MenuService menuService;
	
	// crude operation ->create,,update,delete,edit
	//Create/save
	@PostMapping(value = "/Menu")
	public ResponseEntity<String> createMenu( @RequestBody Menu menu){
		String st= menuService.upsert(menu);
		return new ResponseEntity<>(st,HttpStatus.CREATED);
		
	}
	
	//Get/retrieve the data
	@GetMapping("/Menu/{id}")
	public ResponseEntity<Menu> getMenu(@PathVariable("id") Integer id){
		Menu menu= menuService.getById(id);
		return new ResponseEntity<>(menu , HttpStatus.OK);
		
	}
	//Delete aRecord
	@DeleteMapping("/Menu/{id}")
	public ResponseEntity<String> deleteById( @PathVariable("id") Integer id){
		String st = menuService.deleteById(id);
		return  new ResponseEntity<>("delete record", HttpStatus.OK);
		
	}
	//Upset means insert& update 
	@PutMapping("/Menu")
	public ResponseEntity<String> upsetStudent(@RequestBody Menu menu){
		String st= menuService.upsert(menu);
		return  new ResponseEntity<>(" update record", HttpStatus.OK);
		
	}
	//Retrieve all the Record at time
	@GetMapping("/Menus")
	public ResponseEntity<List<Menu>> getAllMenus(Menu menu){
		List<Menu> allMenus= menuService.getAllMenus();
		return  new ResponseEntity<>(allMenus,HttpStatus.OK);
		
	}
}
