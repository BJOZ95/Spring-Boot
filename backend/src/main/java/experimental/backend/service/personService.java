package experimental.backend.service;

import java.util.List;

import experimental.backend.entity.person;

public interface personService {
    
    public List<person> findall();
    public person save(person person);
    public person findById(Long id);
    public person update(person person, Long id);
    public void delete(person person);
    public person findByName(String name);
    public person findByNum_identification(String Num_identification);
}
