package linhVu.repository;

import linhVu.model.BlogRESTful;
import linhVu.model.CategoryRESTful;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<CategoryRESTful,Long> {

}
