package experimental.backend.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import experimental.backend.entity.Sucursal;
import experimental.backend.service.sucursalService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class sucursalControler {

    @Autowired sucursalService sucursalService;

    @GetMapping(value = "/sucursal")
    public ResponseEntity<Object>get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            List<Sucursal> list = sucursalService.findall();
            return new ResponseEntity<Object>(list,HttpStatus.OK); 
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    @GetMapping(value = "/sucursal/{id}")
    public ResponseEntity<Object>getById(@PathVariable("id") Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Sucursal data = sucursalService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK); 
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @PostMapping(value = "/sucursal") 
        public ResponseEntity<Object> create(@RequestBody Sucursal sucursal){
            Map<String, Object> map = new HashMap<String, Object>();
            try{
                Sucursal res = sucursalService.save(sucursal);
                return new ResponseEntity<Object>(res,HttpStatus.OK); 
            }
            catch (Exception e){
                map.put("message", e.getMessage());
                return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
        /**
     * @param sucursal
     * @param id
     * @return
     */
    @PutMapping("sucursal/{id}")
    public ResponseEntity<Object> update(@RequestBody Sucursal sucursal, @PathVariable Long id){
        try{
            Sucursal currentSucursal = sucursalService.findById(id);

            currentSucursal.setProvincia(sucursal.getProvincia());
            currentSucursal.setCiudad(sucursal.getCiudad());
            currentSucursal.setDireccion(sucursal.getDireccion());          
            Sucursal res = sucursalService.save(sucursal);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/sucursal/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
    Map<String, Object> map = new HashMap<String, Object>();
        try{
            Sucursal curretSucursal = sucursalService.findById(id);
            sucursalService.delete(curretSucursal);
            map.put("Eliminado", true);
            return new ResponseEntity<>(map,HttpStatus.OK); 
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 



}
