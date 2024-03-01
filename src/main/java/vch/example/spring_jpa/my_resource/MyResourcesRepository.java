package vch.example.spring_jpa.my_resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyResourcesRepository extends JpaRepository<MyResource, Long> {
}
