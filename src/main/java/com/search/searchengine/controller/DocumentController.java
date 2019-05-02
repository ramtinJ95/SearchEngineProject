package com.search.searchengine.controller;

import com.search.searchengine.model.DocumentES;
import com.search.searchengine.repository.DocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    DocumentDao documentDao;

    public DocumentController(DocumentDao documentDao){
        this.documentDao = documentDao;
    }

    @GetMapping("/{documentId}")
    public Map<String, Object> getDocumentById(@PathVariable String documentId){
        return documentDao.getDocumentById(documentId);
    }

    @GetMapping("/search/{query}")
    public String queryIndex(@PathVariable String query) {
        return documentDao.getDocumentsForQuery(query);
    }

    // insert document
    @PostMapping
    public DocumentES insertDocument(@RequestBody DocumentES document) throws Exception {
        return documentDao.insertDocument(document);
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
