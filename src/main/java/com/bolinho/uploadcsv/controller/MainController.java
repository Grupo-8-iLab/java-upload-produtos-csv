package com.bolinho.uploadcsv.controller;

import com.bolinho.uploadcsv.util.UploadS3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    @GetMapping("")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("/telaupload")
    public String viewUploadPage() {
        return "telaUpload";
    }

    @GetMapping("/telaclientes")
    public String viewClientPage() {
        return "cliente";
    }

    @GetMapping("/telacadastrarclientes")
    public String viewCreateClientPage() {
        return "cadastrarCliente";
    }

    @GetMapping("/telalistarclientes")
    public String viewGetClientPage() {
        return "listarClientes";
    }

    @GetMapping("/telapedidos")
    public String viewOrderedPage() {
        return "pedidos";
    }

    @GetMapping("/telaprodutos")
    public String viewProductsPage() {
        return "produtos";
    }

    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description, @RequestParam("file") MultipartFile multipart) {
        String fileName = multipart.getOriginalFilename();

        System.out.println("Description: " + description);
        System.out.println("filename: " + fileName);

        String message = "";

        try {
            UploadS3.uploadFile(fileName, multipart.getInputStream());
            message = "Your file has been uploaded successfully!";
        } catch (Exception ex) {
            message = "Error uploading file: " + ex.getMessage();
        }

        model.addAttribute("message", message);

        return "mensagem";
    }
}
