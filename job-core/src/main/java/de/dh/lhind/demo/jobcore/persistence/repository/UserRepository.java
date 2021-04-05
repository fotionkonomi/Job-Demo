package de.dh.lhind.demo.jobcore.persistence.repository;

import de.dh.lhind.demo.jobcore.persistence.entities.User;

import java.util.Optional;

public interface UserRepository extends ParentRepository<User, Long> {
    Optional<User> findByEmail(final String email);
}
