package vch.example.spring_jpa.author;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
//    @Query("UPDATE AUTHOR_TBL SET a a.age = ")
//    int updateAuthor(Short newAge, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE AUTHOR_TBL a SET a.age = :age WHERE a.id = :id")
    int updateAuthorAge(short age, long id);
    @Modifying
    @Transactional
    @Query("UPDATE AUTHOR_TBL a SET a.age = :age")
    int updateAuthorsAge(short age);
    //select * from author_tbl where first_name = ''
    List<Author> findByFirstName(String firstName);
    //select * from author_tbl where first_name = ''
    List<Author> findAllByFirstName(String firstName);
    //select * from author_tbl where first_name = ''
    List<Author> findAllByFirstNameIgnoreCase(String firstName);
    //select * from author_tbl where first_name like '%firstName%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);
    //select * from author_tbl where first_name like '%firstName'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);
    //select * from author_tbl where first_name like 'firstName'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);
    //select * from author_tbl where first_name IN ('x1', 'x2', 'x3')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> fNames);
}
