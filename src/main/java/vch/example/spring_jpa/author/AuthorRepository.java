package vch.example.spring_jpa.author;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    List<Author> findUsersByFirstNameContaining(@Param("searchString") String searchString);
//    List<Author> getByNamedQueryContained(@Param("needle") String needle);
    List<Author> findByNamedQuery(@Param("firstName") String firstName);
    @Modifying//require to update/delete
    @Transactional//require to update/delete
    void updateByNamedQuery(@Param("newName") String newName);
    @Modifying//require to update/delete
    @Transactional//require to update/delete
    @Query("UPDATE AUTHOR_TBL a SET a.age = :age WHERE a.id = :id")
    int updateAuthorAge(short age, long id);
    @Modifying//require to update/delete
    @Transactional//require to update/delete
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
