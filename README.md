# BJT Simulator NPN — React Native (Expo)

App mobile para simulação de circuitos com transistor NPN.

---

## 📱 Como gerar o APK

### Pré-requisitos
- [Node.js](https://nodejs.org/) v18 ou superior
- Conta gratuita em [expo.dev](https://expo.dev) (para build na nuvem)

---

## 🚀 Opção 1 — Build na Nuvem com EAS (RECOMENDADO)

> Não precisa instalar Android Studio. O APK é compilado nos servidores da Expo.

### Passo a passo:

```bash
# 1. Instale as dependências
npm install

# 2. Instale o CLI do Expo e EAS globalmente
npm install -g expo-cli eas-cli

# 3. Faça login na sua conta Expo
eas login

# 4. Configure o projeto (só na primeira vez)
eas build:configure

# 5. Gere o APK (perfil "preview" = .apk direto)
eas build --platform android --profile preview
```

Após ~5 minutos, você receberá um **link para baixar o .apk** direto no celular!

---

## 🔧 Opção 2 — Testar localmente com Expo Go

> Teste instantâneo no celular sem gerar APK.

```bash
# 1. Instale as dependências
npm install

# 2. Inicie o servidor de desenvolvimento
npx expo start

# 3. Escaneie o QR code com o app "Expo Go" (Android/iOS)
```

Baixe o **Expo Go** na Play Store:  
👉 https://play.google.com/store/apps/details?id=host.exp.exponent

---

## 📦 Estrutura do Projeto

```
bjt-simulator/
├── App.js          # App principal (toda a lógica e UI)
├── app.json        # Configurações do Expo
├── eas.json        # Configurações de build
├── package.json    # Dependências
└── assets/
    └── icon.png    # Ícone do app (crie uma imagem 1024x1024)
```

---

## ⚡ Variáveis de entrada

| Variável | Descrição | Unidade |
|----------|-----------|---------|
| VBB | Tensão da fonte da base | V |
| VCC | Tensão da fonte do coletor | V |
| RB | Resistor de base | kΩ |
| RC | Resistor de coletor | kΩ |
| β | Ganho de corrente (hFE) | — |

## 📊 Resultados calculados

| Resultado | Fórmula |
|-----------|---------|
| IB | (VBB − 0.7) / RB |
| IC | β × IB (limitado por saturação) |
| VCE | VCC − IC × RC |
| PT | VCE × IC |

---

## 🌡️ Regiões de operação detectadas

- **Região Ativa** → VCE > 0.2V: modo amplificador
- **Saturação** → VCE ≤ 0.2V: transistor em plena condução  
- **Corte** → IB ≤ 0: transistor bloqueado
