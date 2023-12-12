/* CodingNomads (C)2023 */
package com.codingnomads.springtest.testingjsonresponsecontent.repositories;

import com.codingnomads.springtest.testingjsonresponsecontent.models.Review;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    ArrayList<Review> findByUsername(String username);
}
