package blog.API.repositories;

import blog.API.models.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TemaRepository extends JpaRepository<Tema,Integer> {
}
