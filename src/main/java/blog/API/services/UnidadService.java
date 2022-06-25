package blog.API.services;

import blog.API.models.Unidad;
import blog.API.repositories.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Unidad> findAll() throws Exception {
        try {
            return unidadRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Unidad findById(Integer id) throws Exception {
        try {
            Optional<Unidad> entityOptional = unidadRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Unidad save(Unidad entity) throws Exception {
        try {
            entity = unidadRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Unidad update(Integer id, Unidad entity) throws Exception {
        try {
            Optional<Unidad> entityOptional = unidadRepository.findById(id);
            Unidad unidad = entityOptional.get();
            unidad = unidadRepository.save(entity);
            return unidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (unidadRepository.existsById(id)) {
                unidadRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}