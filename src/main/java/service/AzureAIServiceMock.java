package service;

public class AzureAIServiceMock {

    public String analisarSentimento(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "NEUTRAL";
        }
        
        String textoLower = texto.toLowerCase();

        if (textoLower.contains("urgente") || textoLower.contains("problema") || textoLower.contains("cancelar")) {
            return "NEGATIVE";
        } else if (textoLower.contains("excelente") || textoLower.contains("parabéns") || textoLower.contains("feliz")) {
            return "POSITIVE";
        } else {
            return "NEUTRAL";
        }
    }
}