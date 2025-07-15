/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.io.IOException;

@Data
@Builder
public class FileResponse {

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public static File createTmpFile(String s, String s1) throws IOException {
        return File.createTempFile("dune", ".jpeg");
    }
}
