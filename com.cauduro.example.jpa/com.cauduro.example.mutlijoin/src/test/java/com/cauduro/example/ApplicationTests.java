package com.cauduro.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cauduro.example.entity.Child;
import com.cauduro.example.entity.GrandParent;
import com.cauduro.example.entity.Parent;
import com.cauduro.example.repository.GrandParentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
class ApplicationTests {

  @Autowired private GrandParentRepository repo;

  @Test
  public void testEntity() throws JsonProcessingException {
    // child
    Child child = new Child();
    child.setName("child");
    // parent
    Parent parent = new Parent();
    parent.setFk2("fk2");
    Set<Child> childs = new HashSet<>();
    childs.add(child);
    parent.setChilds(childs);
    // gparent
    GrandParent gparent = new GrandParent();
    Set<Parent> parents = new HashSet<>();
    parents.add(parent);
    gparent.setParents(parents);

    gparent = repo.saveAndFlush(gparent);

    assertNotNull(gparent);
  }
}
