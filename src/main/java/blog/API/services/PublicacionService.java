package blog.API.services;

import blog.API.models.Publication;
import blog.API.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PublicacionService {

    @Autowired
    private PublicationRepository publicationRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Publication> findAll() throws Exception {
        try {
            return publicationRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Publication findById(Integer id) throws Exception {
        try {
            Optional<Publication> entityOptional = publicationRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Publication save(Publication entity) throws Exception {
        try {
            entity = publicationRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Publication update(Integer id, Publication entity) throws Exception {
        try {
            Optional<Publication> entityOptional = publicationRepository.findById(id);
            Publication publication = entityOptional.get();
            publication = publicationRepository.save(entity);
            return publication;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (publicationRepository.existsById(id)) {
                publicationRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}