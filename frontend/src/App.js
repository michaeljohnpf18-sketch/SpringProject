import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import ProductList from "./components/ProductList";
import ProductForm from "./components/ProductForm";
import CategoryList from "./components/CategoryList";
import CategoryForm from "./components/CategoryForm";

function App() {
  return (
    <Router>
      <nav>
        <Link to="/products">Products</Link> |{" "}
        <Link to="/add-product">Add Product</Link> |{" "}
        <Link to="/categories">Categories</Link> |{" "}
        <Link to="/add-category">Add Category</Link>
      </nav>

      <Routes>
        <Route path="/products" element={<ProductList />} />
        <Route path="/add-product" element={<ProductForm />} />
        <Route path="/categories" element={<CategoryList />} />
        <Route path="/add-category" element={<CategoryForm />} />
      </Routes>
    </Router>
  );
}

export default App;
