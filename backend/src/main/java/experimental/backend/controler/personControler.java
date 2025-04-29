package experimental.backend.controler;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import experimental.backend.entity.person;
import experimental.backend.service.personService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1")
public class personControler {

    @Autowired
    private personService personService;

    @GetMapping(value = "/person")
    public ResponseEntity<Object>get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            List<person> list = personService.findall();
            return new ResponseEntity<Object>(list,HttpStatus.OK); 
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping(value = "/person/{id}")
    public ResponseEntity<Object>getById(@PathVariable("id") Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            person data = personService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK); 
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/person") 
        public ResponseEntity<Object> create(@RequestBody person person){
            Map<String, Object> map = new HashMap<String, Object>();
            try{
                person res = personService.save(person);
                return new ResponseEntity<Object>(res,HttpStatus.OK); 
            }
            catch (Exception e){
                map.put("message", e.getMessage());
                return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    /**
     * @param person
     * @param id
     * @return
     */
    @PutMapping("person/{id}")
    public ResponseEntity<Object> update(@RequestBody person person, @PathVariable Long id){
        try{
            person currentPerson = personService.findById(id);

            currentPerson.setName(person.getName());
            currentPerson.setIdentification(person.getIdentification());
            currentPerson.setNum_identification(person.getNum_identification());
            currentPerson.setEmail(person.getEmail());
            currentPerson.setPhone(person.getPhone());
            currentPerson.setMainProvince(person.getMainProvince());
            currentPerson.setMainAddress(person.getMainAddress());
            currentPerson.setSucursal(person.getSucursal());

            
            
            person res = personService.save(person);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
    Map<String, Object> map = new HashMap<String, Object>();
        try{
            person curretPerson = personService.findById(id);
            personService.delete(curretPerson);
            map.put("Eliminado", true);
            return new ResponseEntity<>(map,HttpStatus.OK); 
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  

}
