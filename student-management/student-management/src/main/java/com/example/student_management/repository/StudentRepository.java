package com.example.student_management.repository;

import com.example.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);

    //pour compter le nombre d'etudiants groupes par leur année de naissance
    //regroupe les etudiants par annees de naissance et retourne le nombre d'etudiants pour chaque annee
    @Query("SELECT YEAR(s.dateNaissance), COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();
}
