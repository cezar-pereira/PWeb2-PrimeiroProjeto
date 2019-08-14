package br.ifal.edu.projetowebv2.repository;

import org.springframework.data.repository.CrudRepository;

import br.ifal.edu.projetowebv2.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findByNameContaining(String name);
}
