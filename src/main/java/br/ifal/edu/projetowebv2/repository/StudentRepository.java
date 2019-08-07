package br.ifal.edu.projetowebv2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ifal.edu.projetowebv2.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
