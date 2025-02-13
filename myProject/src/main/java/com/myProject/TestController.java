package com.myProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/")
public class TestController {
	
	@GetMapping("/test")
	public Emp test(@RequestParam Map<String, String> emp){
		Optional<Emp> data = emp.keySet().stream().
				map(x->new Emp(emp.get("name"),Integer.parseInt(emp.get("rno")),
				Integer.parseInt(emp.get("salary")))).findAny();
//		Emp empobj = new Emp();
//		empobj.setName(emp.get("name"));
//		empobj.setRno(Integer.parseInt(emp.get("rno")));
//		empobj.setSalary(Integer.parseInt(emp.get("salary")));
		return data.get();
		
		
		
		
//		Emp emp1 = new Emp("Ravi", 10, 40000);
//		Emp emp2 = new Emp("Raju", 30, 10000);
//		Emp emp3 = new Emp("Ramu", 20, 80000);
//		List<Emp> emplist = new ArrayList<>();
//		emplist.add(emp1);
//		emplist.add(emp2);
//		emplist.add(emp3);
//		
//		
//		 Optional<Emp> yyy =emplist.stream().
//				filter(x->x.getName().equals(name) && x.getRno()==rno).
//				findAny();
//		 
//		 return yyy.isPresent()?yyy.get():null;
	}
	@PostMapping("/save")
	public List<Emp> saveData(@RequestBody  Emp emp ) {
		Emp emp1 = new Emp("Ravi", 10, 40000);
		Emp emp2 = new Emp("Raju", 30, 10000);
		Emp emp3 = new Emp("Ramu", 20, 80000);
		List<Emp> emplist = new ArrayList<>();
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);
		emplist.add(emp);
		return emplist;
	}
	@PutMapping("/update")
	public List<Emp> updateData(@RequestBody  Emp emp ) {
		Emp emp1 = new Emp("Ravi", 10, 40000);
		Emp emp2 = new Emp("Raju", 30, 10000);
		Emp emp3 = new Emp("Ramu", 20, 80000);
		List<Emp> emplist = new ArrayList<>();
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);

		Emp res = emplist.stream().filter(x->x.getRno()==emp.getRno()).findFirst().get();
		emplist.remove(res);
		res.setName(emp.getName());
		res.setSalary(emp.getSalary());
		emplist.add(res);
		return emplist;
	}
	@DeleteMapping("/delete")
	public List<Emp> deleteData(@RequestParam Integer empid ) {
		Emp emp1 = new Emp("Ravi", 10, 40000);
		Emp emp2 = new Emp("Raju", 30, 10000);
		Emp emp3 = new Emp("Ramu", 20, 80000);
		List<Emp> emplist = new ArrayList<>();
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);

		Emp res = emplist.stream().filter(x->x.getRno()==empid).findFirst().get();
		emplist.remove(res);

		return emplist;
	}
	
			
		
		

	
}
