package experimental.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import experimental.backend.dao.personDao;
import experimental.backend.entity.person;
import jakarta.transaction.Transactional;

@Service
public class personServiceImplement implements personService {
    @Autowired
    private personDao personDao;

    @Override
    @Transactional
    public List<person> findall() {
        return (List<person>) personDao.findAll();

    }
    @Override
    @Transactional
    public person save(person person) {
        return personDao.save(person);
    }
    @Override
    @Transactional
    public person findById(Long id) {
        return personDao.findById(id).orElse(null); 
    }
    @Override
    @Transactional
    public person update(person person, Long id) {
        person.setId(id);
        return personDao.save(person);
    }
    @Override   
    @Transactional
    public void delete(person person) {
        personDao.delete(person);
    }
    @Override   
    @Transactional
    public person findByName(String name) {
        return personDao.findAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    @Override
    @Transactional  
    public person findByNum_identification(String Identification) {
        return personDao.findAll().stream()
                .filter(p -> p.getIdentification().equalsIgnoreCase(Identification))
                .findFirst()
                .orElse(null);
    }
    

}
