package beetle.Repositories;

import beetle.Entities.Receipt;
import beetle.Entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    @Query("SELECT c FROM Receipt c WHERE c.user = :user")
    Receipt findByUser(@Param("user")User user);
}
