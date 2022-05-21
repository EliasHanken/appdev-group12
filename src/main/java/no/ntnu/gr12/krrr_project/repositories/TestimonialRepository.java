package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Testimonial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Thomas Ystenes
 * Interface for TestimonialRepository
 */

@Repository
public interface TestimonialRepository extends CrudRepository<Testimonial, String> {
}
