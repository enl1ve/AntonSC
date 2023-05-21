package ua.com.antonsh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.antonsh.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
