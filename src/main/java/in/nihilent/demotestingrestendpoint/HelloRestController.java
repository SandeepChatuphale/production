package in.nihilent.demotestingrestendpoint;





import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloRestController {

	@GetMapping("/hello")
	public String hello() {

		System.out.println("In hello");
		return "Hello";
	}

	@GetMapping("/hellowithparam")
	public String helloWithParam(@RequestParam String name) {

		System.out.println("In hello with param"+name);
		return "Hello"+name;

	}



	@PostMapping("/visitor")
	public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor inserted)
	{
		System.out.println(inserted);
		ResponseEntity<Visitor> entity=new ResponseEntity<Visitor>(inserted,HttpStatus.CREATED);
		return entity;

	}



	@DeleteMapping("/visitor/{id}")
	public ResponseEntity<Void> deleteVisitorById(@PathVariable int id)
	{
		System.out.println("in delete");
		System.out.println(id);
		if(id==1) {
			ResponseEntity<Void> entity= new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return entity;
		}
		else {
			System.err.println("Not exist");
			ResponseEntity<Void> entity= new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			return entity;
		}
		}



		@PutMapping("/visitor/{id}")
		public ResponseEntity<Visitor> updateVisitor(@PathVariable int id,@RequestBody Visitor v){
			
			System.err.println("Updated");
			ResponseEntity<Visitor> entity= new ResponseEntity<Visitor>(HttpStatus.OK);
			return entity;
		}

		
		@GetMapping("/visitor/{id}")
		public ResponseEntity<?> findVisitorById(@PathVariable int id)
		{
			System.err.println("find by id"+id);
			Visitor visitor=new Visitor();
			visitor.setId(2);
			visitor.setName("mehta");
			//System.out.println(visitor);
			ResponseEntity<Visitor> entity= new ResponseEntity<Visitor>(visitor,HttpStatus.OK);
			return entity;
		}

	}
