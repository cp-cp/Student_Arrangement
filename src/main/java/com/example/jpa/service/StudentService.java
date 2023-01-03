package com.example.jpa.service;

import com.example.jpa.bean.Student;
import com.example.jpa.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String init()
    {
        String[] name={"John","Jane","Mark", "Mia","David","Emily", "Michael", "Sarah", "Peter", "Elizabeth"};
        String[] college={"Accountant", "Architect", "Engineer", "Lawyer", "Doctor", "Dentist", "Veterinarian", "Psychologist", "Developer", "Designer"};
        for(int i=0;i<10;i++)
        {
            Random random = new Random();
            Student student=new Student();
            student.setName(name[i]);
            student.setCollege(college[i]);
            student.setGender(random.nextInt(2));
            student.setNumber(random.nextInt(10000)+20210000);
            studentRepository.save(student);
        }
        return "成功生成样例数据";
    }

    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    public Optional<Student> getById(int id)
    {
        return studentRepository.findById(id);
    }

    public String add(Student student)
    {
        if(studentRepository.existsById(student.getId()))
            return "重复了";
        else
        {
            studentRepository.save(student);
            return "成功添加"+student;
        }
    }
    public String delete(int id)
    {
        if(studentRepository.existsById(id))
        {
            studentRepository.deleteById(id);
            return "成功删除!";
        }
        else
        {
            return "不存在这个序号的人";
        }
    }

    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

}