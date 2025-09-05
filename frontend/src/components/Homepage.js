import { Link } from "react-router-dom";
import LoginModal from "./LoginModal"; // 👈 Import your modal component

function HomePage() {
  return (
    <div style={{ padding: "20px", textAlign: "center" }}>
      <h1>Welcome to Michael's Store 🛒</h1>
      <p>Manage products and categories easily.</p>

      {/* 👇 Add Login Modal button here */}
      <div style={{ marginBottom: "20px" }}>
        <LoginModal />
      </div>

      <nav style={{ marginTop: "20px" }}>
        <Link to="/products" style={linkStyle}>View Products</Link>
        <Link to="/add-product" style={linkStyle}>Add Product</Link>
        <Link to="/categories" style={linkStyle}>View Categories</Link>
        <Link to="/add-category" style={linkStyle}>Add Category</Link>
      </nav>
    </div>
  );
}

const linkStyle = {
  margin: "0 15px",
  textDecoration: "none",
  padding: "10px 15px",
  border: "1px solid #ccc",
  borderRadius: "5px",
  background: "#f5f5f5",
};

export default HomePage;