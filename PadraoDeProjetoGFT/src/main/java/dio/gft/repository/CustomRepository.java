package dio.gft.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import dio.gft.model.BaseEntity;

@NoRepositoryBean
public interface CustomRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {

}
