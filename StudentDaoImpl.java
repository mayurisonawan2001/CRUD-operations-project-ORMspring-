package com.console.dao;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.console.entity.Student;

public class StudentDaoImpl implements StudentDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public int insert(Student student) {
        return (Integer) hibernateTemplate.save(student);
    }

    public int update(Student student) {
        hibernateTemplate.update(student);
        return student.getId();
    }

    public int delete(int id) {
        Student student = hibernateTemplate.get(Student.class, id);
        if (student != null) {
            hibernateTemplate.delete(student);
        }
        return id;
    }

    public Student getStudent(int id) {
        return hibernateTemplate.get(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return hibernateTemplate.loadAll(Student.class);
    }
}
