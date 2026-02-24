# BJT Simulator NPN

Simulador web interativo de circuitos com transistor NPN.

---

## 🚀 Como Usar

### Requisitos
- Um navegador web moderno (Chrome, Firefox, Edge, Safari)

### Instruções

1. Abra o arquivo `bjt-simulator.html` no seu navegador
2. Ajuste os valores de entrada (VBB, VCC, RB, RC, β)
3. Veja os resultados calculados em tempo real

Não é necessário instalar nada — funciona completamente offline!

---

## 📦 Estrutura do Projeto

```
BJT-Simulator/
├── bjt-simulator.html  # Aplicação completa
├── README.md           # Este arquivo
└── ...
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
