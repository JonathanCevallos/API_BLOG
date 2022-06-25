package blog.API.repositories;


import blog.API.models.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
}
