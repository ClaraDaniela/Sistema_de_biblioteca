#

# 🛍️ Proyecto sistema de biblioteca con React + Vite + React Router

Este proyecto es un sistema de gestión para una biblioteca online creado con **React**, **Vite** y **React Router DOM**.
Incluye navegación, login simulado, CRUD de libros, autores, lectores, prestamos, generacion automatica de multas, lista de libros prohibidos para estudiantes no avanzados y estilos con CSS modular.

---

## 🚀 Requisitos

- Node.js >= 17
- npm >= 8 o yarn

---

## 📦 Instalación y Configuración Inicial

1. Crear proyecto con Vite:

```bash
npm create vite@latest biblioteca-react
```

2. Seleccionar las opciones:

   - **Framework** → `React`
   - **Variant** → `JavaScript`

3. Entrar en la carpeta:

```bash
cd biblioteca-react
```

4. Instalar dependencias:

```bash
npm install
```

5. Instalar React Router DOM:

```bash
npm install react-router-dom
```

6. Instalar lucile-react:

```bash
npm install lucide-react
```

7. Instalar axios para solicitudes HTTP:

```bash
npm install axios
```

8. Iniciar servidor de desarrollo:

```bash
npm run dev
```

La app se abrirá en 👉 `http://localhost:5173`

---

## ⚙️ Configuración de React Router

En `main.jsx`:

```jsx
import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import App from "./App.jsx";

ReactDOM.createRoot(document.getElementById("root")).render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);
```

En `App.jsx` se definen las rutas con `<Routes>` y `<Route>`.

---

## 🛠️ Comandos

- `npm run dev` → Inicia servidor de desarrollo
- `npm run build` → Genera versión optimizada
- `npm run preview` → Previsualiza build

---
