package com.search.searchengine.controller;

import com.search.searchengine.model.DocumentES;
import com.search.searchengine.repository.DocumentDao;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private DocumentDao documentDao;

    public DocumentController(DocumentDao documentDao){
        this.documentDao = documentDao;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getDocumentById(@PathVariable String documentId){
        return documentDao.getDocumentById(documentId);
    }

    // insert document
    @PostMapping
    public DocumentES insertDocument(@RequestBody DocumentES documentES) throws Exception {
        return documentDao.insertDocument(documentES);
    }

    // update document
    @PutMapping("/{id}")
    public Map<String, Object> updateDocumentById(@RequestBody DocumentES documentES, @PathVariable String id){
        return documentDao.updateDocumentById(id, documentES);

    }

    @DeleteMapping("/{id}")
    public void deleteDocumentById(@PathVariable String id){
        documentDao.deleteDocumentById(id);
    }
}
