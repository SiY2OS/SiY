package org.siy.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.siy.common.api.BaseApi;
import org.siy.common.utils.Result;
import org.siy.storage.api.StorageApi;
import org.siy.storage.po.Storage;
import org.siy.storage.service.IStorageService;

import java.io.IOException;

/**
 * @author Ryan
 */

@RestController
@RequestMapping("/storage")
public class StorageController extends BaseApi<Storage> implements StorageApi {

    @Autowired
    private IStorageService storageService;

    @Override
    public Result<String> upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String url = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);
        return Result.success(url);
    }

    @Override
    public ResponseEntity<Resource> fetch(@PathVariable String key) {
        Storage storage = storageService.queryByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if (key.contains("../")) {
            return ResponseEntity.badRequest().build();
        }
        String type = storage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).body(file);
    }

    @Override
    public ResponseEntity<Resource> download(@PathVariable String key) {
        Storage storage = storageService.queryByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if (key.contains("../")) {
            return ResponseEntity.badRequest().build();
        }

        String type = storage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
