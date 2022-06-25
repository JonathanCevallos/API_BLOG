package blog.API.repositories;

import blog.API.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
}
