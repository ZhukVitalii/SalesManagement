package beetle.Repositories;

import beetle.Entities.ProductsInReseipt;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsInReceiptsRepository extends JpaRepository<ProductsInReseipt, Long> {

    @Query("SELECT c FROM ProductsInReseipt c WHERE c.receipt_id = :receipt_id")
    List<ProductsInReseipt> findByReceipt_id(@Param("receipt_id") Long receipt_id);
}
