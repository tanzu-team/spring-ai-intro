package dev.tanzu.demo.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MultiModalController {

    @Value("classpath:data/multimodal.png")
    private Resource image;

    private final ChatClient chatClient;
    
    MultiModalController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping(value = "/chat/explain")
    String explain() {

        // Multimodality API allows model's ability to simultaneously understand and
        // process information from various sources, including text, images, audio, etc.
        
        return chatClient
            .prompt()
            .user(
                u -> u
                    .text("Explain what do you see in this picture?")
                    .media(MimeTypeUtils.IMAGE_PNG, image))
            .call()
            .content();

    }

}
