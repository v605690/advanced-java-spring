/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.repositories;

import com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {
    Long id(Long id);

    List<DatabaseFile> findByFileName(String fileName);
}
