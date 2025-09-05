import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomePage from "./components/Homepage"; // 👈 Import the homepage component
import ProductList from "./components/ProductList";
import ProductForm from "./components/ProductForm";
import CategoryList from "./components/CategoryList";
import CategoryForm from "./components/CategoryForm";

function App() {
  return (
    <Router>
      

      <Routes>
        <Route path="/" element={<HomePage />} />   {/* 👈 New homepage */}
        <Route path="/products" element={<ProductList />} />
        <Route path="/add-product" element={<ProductForm />} />
        <Route path="/categories" element={<CategoryList />} />
        <Route path="/add-category" element={<CategoryForm />} />
      </Routes>
    </Router>
  );
}

export default App;
