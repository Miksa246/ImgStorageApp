package com.example.imgstorageapp.repositories;

import com.example.imgstorageapp.entities.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {

}
