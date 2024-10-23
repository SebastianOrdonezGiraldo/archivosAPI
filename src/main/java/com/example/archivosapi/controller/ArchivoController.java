package com.example.archivosapi.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/archivosapi")
public class ArchivoController {

    // Método para la imagen PNG
    @GetMapping("/imagen/garfield")
    public ResponseEntity<byte[]> getImagenGarfield() throws IOException {
        ClassPathResource imgFile = new ClassPathResource("static/imagen/garfield.png");
        byte[] imageBytes = imgFile.getInputStream().readAllBytes();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"garfield.png\"") // Cambiado a "inline"
                .contentType(MediaType.IMAGE_PNG)
                .body(imageBytes);
    }

    // Método para el archivo PDF
    @GetMapping("/pdf/CurriculumVitae")
    public ResponseEntity<byte[]> getCurriculumVitae() throws IOException {
        ClassPathResource pdfFile = new ClassPathResource("static/pdf/CurriculumVitae.pdf");
        byte[] pdfBytes = pdfFile.getInputStream().readAllBytes();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"CurriculumVitae.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    // Método para el archivo HTML
    @GetMapping("/html/holamundo")
    public ResponseEntity<byte[]> getHtmlHolamundo() throws IOException {
        ClassPathResource htmlFile = new ClassPathResource("static/html/holamundo.html");
        byte[] htmlBytes = htmlFile.getInputStream().readAllBytes();
        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(htmlBytes);
    }

    // Método para el archivo XML
    @GetMapping("/xml/holamundo")
    public ResponseEntity<byte[]> getXmlHolamundo() throws IOException {
        ClassPathResource xmlFile = new ClassPathResource("static/xml/holamundo.xml");
        byte[] xmlBytes = xmlFile.getInputStream().readAllBytes();
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(xmlBytes);
    }
}
