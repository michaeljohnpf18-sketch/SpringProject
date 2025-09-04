import { useState, useEffect } from "react";
import api from "../api";

function ProductForm() {
  const [productName, setName] = useState("");
  const [description, setDesciption] = useState("");
  const [price, setPrice] = useState("");
  const [categoryId, setCategoryId] = useState("");
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    api.get("/categories").then((res) => setCategories(res.data));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    api.post("/products", { productName, categoryId, price, description })
       .then(() => alert("Product created!"));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Add Product</h2>
      <input
        type="text"
        placeholder="Product name"
        value={productName}
        onChange={(e) => setName(e.target.value)}
      />
      <br />
      <input
        type="text"
        placeholder="Description"
        value={description}
        onChange={(e) => setDesciption(e.target.value)}
      />
      <br />
      <input
        type="number"
        placeholder="Price" 
        value={price}
        onChange={(e) => setPrice(e.target.value)}
      />
      <br />
      <select
        value={categoryId}
        onChange={(e) => setCategoryId(e.target.value)}
      >
        <option value="">Select category</option>
        {categories.map((c) => (
          <option key={c.id} value={c.id}>{c.name}</option>
        ))}
      </select>
      <button type="submit">Save</button>
    </form>
  );
}

export default ProductForm;
