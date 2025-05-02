# spring-ai-intro

Gentle introduction to Spring AI.

## How to run

```shell
./mvnw spring-boot:run
```

## Chat Client API Examples

All chat examples are packaged in `chat` package, e.g.
* SimpleChatController
* PromptChatController
* RoleController
* MultiModalController


### SimpleChatController

`SimpleChatController` demonstrates a simple ChatClient API that connects to your LLM model.

```shell
http localhost:8080/chat/simple
```

```shell
http 'localhost:8080/chat/simple?query=tell-me-a-joke'
```

### PromptChatController

`PromptChatController` demonstrates simple prompt templating.

```shell
http 'localhost:8080/chat/joke'
```

```shell
http 'localhost:8080/chat/joke?topic=ai'
```

```shell
http 'localhost:8080/chat/joke?lang=swedish'
```

### RoleController

`RoleController` demonstrates use of `user` and `system` prompts.


```shell
http localhost:8080/chat/fruit
```

```shell
http localhost:8080/chat/veggie
```

### MultiModalController

`MultiModalController` demonstrates usage of Multimodality API and how it can simultaneously
understand and process from various sources, including text, images, audio, video, etc.

This will work on OpenAI, but not on Ollama `llama3.2` model as it is a text-based AI.

```shell
http localhost:8080/chat/explain
```
## RAG Example

`LoadController` processes JSON objects and stores their embeddings in a vector store.

```shell
http localhost:8080/raffle/load/json
```

`RaffleController` leverages the data in the vector store and answers questions about the stored data.

```shell
http localhost:8080/raffle/chat
```

```shell
http 'localhost:8080/raffle/chat?question=list all positive feedback'
```

```shell
http 'localhost:8080/raffle/chat?question=list all negative feedback'
```

