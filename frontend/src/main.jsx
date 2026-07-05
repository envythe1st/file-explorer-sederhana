import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import "./styles/app.css";
import "./styles/toolbar.css";
import "./styles/sidebar.css";
import "./styles/explorer.css";
import "./styles/breadcrumb.css";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App />
  </StrictMode>,
);
