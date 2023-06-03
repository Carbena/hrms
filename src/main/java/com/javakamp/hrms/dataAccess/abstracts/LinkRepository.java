package com.javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javakamp.hrms.entities.concretes.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link,Integer>{

}
