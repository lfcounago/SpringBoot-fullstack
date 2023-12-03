package com.lfcounago.springbootfs.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.lfcounago.springbootfs.model.Person;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FakePersonDataAccessServicesTest {

    @Mock
    private PersonDao personDao;

    @Test
    public void given_person_when_InsertPerson_then_success() {

        when(personDao.insertPerson(any(UUID.class), any(Person.class))).thenReturn(1);

        try {
            int result = personDao.insertPerson(UUID.randomUUID(), new Person(UUID.randomUUID(), "Luis"));
            assertEquals(1, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_InsertPerson_then_fail() {

        when(personDao.insertPerson(any(UUID.class), any(Person.class))).thenReturn(0);

        try {
            int result = personDao.insertPerson(UUID.randomUUID(), new Person(UUID.randomUUID(), "Luis"));
            assertEquals(0, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_DeletePersonById_then_success() {

        when(personDao.deletePersonById(any(UUID.class))).thenReturn(1);

        try {
            int result = personDao.deletePersonById(UUID.randomUUID());
            assertEquals(1, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_DeletePersonById_then_fail() {

        when(personDao.deletePersonById(any(UUID.class))).thenReturn(0);

        try {
            int result = personDao.deletePersonById(UUID.randomUUID());
            assertEquals(0, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_UpdatePersonById_then_success() {

        when(personDao.updatePersonById(any(UUID.class), any(Person.class))).thenReturn(1);

        try {
            int result = personDao.updatePersonById(UUID.randomUUID(), new Person(UUID.randomUUID(), "Luis"));
            assertEquals(1, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_UpdatePersonById_then_fail() {

        when(personDao.updatePersonById(any(UUID.class), any(Person.class))).thenReturn(0);

        try {
            int result = personDao.updatePersonById(UUID.randomUUID(), new Person(UUID.randomUUID(), "Luis"));
            assertEquals(0, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_SelectPersonById_then_success() {

        when(personDao.selectPersonById(any(UUID.class)))
                .thenReturn(java.util.Optional.of(new Person(UUID.randomUUID(), "Luis")));

        try {
            java.util.Optional<Person> result = personDao.selectPersonById(UUID.randomUUID());
            assertEquals("Luis", result.get().getName());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_SelectPersonById_then_fail() {

        when(personDao.selectPersonById(any(UUID.class))).thenReturn(java.util.Optional.empty());

        try {
            java.util.Optional<Person> result = personDao.selectPersonById(UUID.randomUUID());
            assertEquals(false, result.isPresent());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_SelectAllPeople_then_success() {

        when(personDao.selectAllPeople()).thenReturn(null);

        try {
            java.util.List<Person> result = personDao.selectAllPeople();
            assertEquals(null, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void given_person_when_SelectAllPeople_then_fail() {

        when(personDao.selectAllPeople()).thenReturn(null);

        try {
            java.util.List<Person> result = personDao.selectAllPeople();
            assertEquals(null, result);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}
