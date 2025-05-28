
# 🎣 PescaTempo

Aplicativo Android que une o amor pela pesca com informações climáticas em tempo real!  
Digite o nome de uma cidade e descubra se é um bom dia pra jogar a linha na água. 🌤️🌧️

<img src="https://github.com/user-attachments/assets/4236fd8b-3151-490d-9dc6-9f6242a7e904" alt="Logo PescaTempo" width="200"/>


---

## 📱 Funcionalidades

- 🔐 Tela de login e cadastro (Firebase)
- 🌍 Busca de cidade via caixa de texto
- 🌡️ Exibição da temperatura atual
- ☁️ Exibição da descrição do clima (ex: "predominantemente nublado")
- 🎨 Interface customizada com tema de pesca

---

## 🧪 Tecnologias utilizadas

- **Java (Android)**
- **Retrofit** – requisições HTTP
- **Gson** – conversão JSON
- **Firebase Auth + Firestore** – login e persistência
- **OpenWeatherMap API** – dados climáticos

---

## ⚙️ Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/pescatempo.git
   ```
2. Abra no **Android Studio**
3. Adicione sua chave da OpenWeatherMap no arquivo `WeatherService.java`:
   ```java
   @Query("appid") String apiKey // substitua pela sua
   ```
4. Rode em um emulador ou dispositivo físico 📱

---

## 🌐 API usada

[OpenWeatherMap](https://openweathermap.org/api)  
Endpoint principal:  
```
https://api.openweathermap.org/data/2.5/weather?q={cidade}&appid={sua_api_key}&units=metric&lang=pt_br
```

---

## 💡 Inspiração

O app simula um guia de pesca moderno, oferecendo clima em tempo real para ajudar pescadores a planejar melhor suas pescarias.

---

## 📸 Screenshots

| Tela Principal                      | Clima Buscado |
|------------------------------------|----------------|
|  ![Captura de tela 2025-05-21 205213](https://github.com/user-attachments/assets/ba061b0d-4692-44e2-a293-2fda4b113861) |  ![Captura de tela 2025-05-21 230428](https://github.com/user-attachments/assets/900cfa44-f186-4ff0-9b50-d3852aa4cf7b) |
---

## 📌 Observações

- Projeto feito para fins educacionais
- API gratuita do OpenWeatherMap (pode ter limite de uso)

---

## ⭐ Se curtiu, deixa uma estrela!
