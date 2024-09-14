package dev.unscrud.api_milhas.domain.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ImagemUtil {
    public static String gerarUrlImagem(String nomeImagem){
        String urlBase = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        return urlBase + "/images/" + nomeImagem;
    }
}
