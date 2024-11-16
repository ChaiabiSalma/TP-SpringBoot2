package com.example.student_management.services;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //enregistrer un etudiant dans la base de données
    public Student save(Student student){
        return  studentRepository.save(student);
    }

    //il tente de récupérer un étudiant par son id si l'étudiant est trouvé il est supprimé sinon il retoune que l'étudiant n'existe pas
    public boolean delete (int id){
        Optional<Student> studentOptional=Optional.ofNullable(studentRepository.findById(id));
        if(studentOptional.isPresent()){
            studentRepository.delete(studentOptional.get());
            return  true;
        }else {
            return false;
        }
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public  Long countStudents(){
        return studentRepository.count();
    }

    public Collection<?> findNbrStudentByYear(){
        return studentRepository.findNbrStudentByYear();
    }

}
