package linhVu.repository;

import linhVu.model.BlogRESTful;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<BlogRESTful,Long> {
}
