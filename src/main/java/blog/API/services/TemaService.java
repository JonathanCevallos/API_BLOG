package blog.API.services;

import blog.API.models.Tema;
import blog.API.repositories.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Tema> findAll() throws Exception {
        try {
            return temaRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Tema findById(Integer id) throws Exception {
        try {
            Optional<Tema> entityOptional = temaRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Tema save(Tema entity) throws Exception {
        try {
            entity = temaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Tema update(Integer id, Tema entity) throws Exception {
        try {
            Optional<Tema> entityOptional = temaRepository.findById(id);
            Tema tema = entityOptional.get();
            tema = temaRepository.save(entity);
            return tema;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (temaRepository.existsById(id)) {
                temaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}