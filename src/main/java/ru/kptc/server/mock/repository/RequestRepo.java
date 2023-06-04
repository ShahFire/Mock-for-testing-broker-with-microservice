package ru.kptc.server.mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kptc.server.mock.model.Request;

public interface RequestRepo extends JpaRepository<Request, Integer> {
    Request findById(int id);
}
